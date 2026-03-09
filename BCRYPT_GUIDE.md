# Encriptación de Contraseñas con BCrypt

## Descripción

Este proyecto utiliza **BCrypt** para encriptar y verificar contraseñas de forma segura. BCrypt es un algoritmo de hash adaptativo que es muy resistente a ataques de fuerza bruta.

## Configuración

### 1. Dependencia Maven
La dependencia de Spring Security proporciona BCrypt:
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>
```

### 2. Bean de PasswordEncoder
En `SecurityConfig.java`:
```java
@Bean
public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
}
```

## Uso

### Opción 1: Usar PasswordEncoder directamente

```java
@Service
@RequiredArgsConstructor
public class UserService {
    private final PasswordEncoder passwordEncoder;
    
    // Encriptar contraseña
    public void createUser(String rawPassword) {
        String encryptedPassword = passwordEncoder.encode(rawPassword);
        // Guardar encryptedPassword en la base de datos
    }
    
    // Verificar contraseña
    public boolean authenticate(String rawPassword, String storedPassword) {
        return passwordEncoder.matches(rawPassword, storedPassword);
    }
}
```

### Opción 2: Usar PasswordUtils (Recomendado)

```java
@Service
@RequiredArgsConstructor
public class UserService {
    private final PasswordUtils passwordUtils;
    
    // Encriptar contraseña
    public void createUser(String rawPassword) {
        String encryptedPassword = passwordUtils.encodePassword(rawPassword);
        // Guardar encryptedPassword en la base de datos
    }
    
    // Verificar contraseña en login
    public boolean authenticate(String rawPassword, String storedPassword) {
        return passwordUtils.matchesPassword(rawPassword, storedPassword);
    }
}
```

## Métodos Disponibles

### `passwordEncoder.encode(String rawPassword)`
- **Descripción**: Encripta una contraseña en texto plano
- **Parámetro**: `rawPassword` - Contraseña sin encriptar
- **Retorna**: String - Contraseña encriptada
- **Ejemplo**: 
```java
String encrypted = passwordEncoder.encode("miContraseña123");
// Resultado: $2a$10$slYQmyNdGzin7olVN3p3aO2xd1S5LjWmWiU6d1JVzNHI5ZSz1t3WK
```

### `passwordEncoder.matches(String rawPassword, String encodedPassword)`
- **Descripción**: Verifica si una contraseña coincide con su versión encriptada
- **Parámetros**: 
  - `rawPassword` - Contraseña en texto plano
  - `encodedPassword` - Contraseña encriptada
- **Retorna**: boolean - true si coinciden
- **Ejemplo**:
```java
boolean isMatch = passwordEncoder.matches("miContraseña123", 
    "$2a$10$slYQmyNdGzin7olVN3p3aO2xd1S5LjWmWiU6d1JVzNHI5ZSz1t3WK");
// Resultado: true
```

### `passwordEncoder.upgradeEncoding(String encodedPassword)`
- **Descripción**: Verifica si una contraseña necesita ser re-encriptada con una versión más nueva de BCrypt
- **Parámetro**: `encodedPassword` - Contraseña encriptada
- **Retorna**: boolean - true si requiere actualización
- **Uso**: Útil durante login para actualizar contraseñas antiguas

## Ejemplo Completo de Autenticación

```java
@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordUtils passwordUtils;
    
    public boolean login(String email, String rawPassword) {
        // 1. Buscar usuario por email
        User user = userRepository.findByEmail(email);
        if (user == null) {
            return false;
        }
        
        // 2. Verificar contraseña
        if (!passwordUtils.matchesPassword(rawPassword, user.getPassword())) {
            return false;
        }
        
        // 3. (Opcional) Actualizar contraseña si usa versión antigua de BCrypt
        if (passwordUtils.requiresUpgrade(user.getPassword())) {
            String newEncodedPassword = passwordUtils.encodePassword(rawPassword);
            user.setPassword(newEncodedPassword);
            userRepository.save(user);
        }
        
        return true;
    }
}
```

## Ventajas de BCrypt

✅ **Adaptativo**: Permite ajustar la "fuerza" del hash para adaptarse a hardware más rápido  
✅ **Resistente a ataques**: Incluye salt automático para prevenir ataques de diccionario  
✅ **Lento por diseño**: Cada hash toma tiempo, ralentizando ataques de fuerza bruta  
✅ **Estándar de la industria**: Ampliamente usado y confiado  
✅ **Integrado en Spring Security**: Viene con Spring Boot  

## Consideraciones de Seguridad

⚠️ **Nunca** almacenes contraseñas en texto plano  
⚠️ **Siempre** usa `passwordEncoder.encode()` antes de guardar  
⚠️ **Siempre** usa `passwordEncoder.matches()` para verificar  
⚠️ **Nunca** compares strings encriptados directamente con `equals()`  
⚠️ **Usa HTTPS** para transmitir contraseñas  

## Información Técnica

- **Algoritmo**: PBKDF2 con HMAC-SHA256 (BCrypt internamente usa Blowfish)
- **Fuerza por defecto**: 10 (puede ajustarse en BCryptPasswordEncoder)
- **Formato**: `$2a$10$...` (versión $2a$, fuerza 10, resto es salt+hash)
- **Tiempo típico**: ~100ms por operación (lo que lo hace seguro)

