package com.metaphorce.CineMagic.seguridad;

import com.metaphorce.CineMagic.configuracion.JwtProperties;
import com.metaphorce.CineMagic.entidades.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {

    // Accedemos a configuraciones como expiración y clave con las propiedades
    @Autowired
    private JwtProperties jwtProperties;

    // Generar Token
    public String generarToken(Usuario usuario){
        return Jwts.builder()
                .setSubject(usuario.getUsername())
                .claim("rol", usuario.getRol().getNombre_rol())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + jwtProperties.getExpiration()))
                .signWith(SignatureAlgorithm.HS256, jwtProperties.getSecret())
                .compact();
    }

    // Valida Token
    public Claims validarToken(String token){
        return Jwts.parser()
                .setSigningKey(jwtProperties.getSecret())
                .parseClaimsJws(token)
                .getBody();
    }
}
