package com.metaphorce.CineMagic.seguridad;

import com.metaphorce.CineMagic.servicios.UserDetailsServiceImpl;
import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jdk.swing.interop.SwingInterOpUtils;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final UserDetailsServiceImpl userDetailsService;
    private final JwtUtil jwtUtil;

    public JwtAuthenticationFilter(UserDetailsServiceImpl userDetailsService, JwtUtil jwtUtil) {
        this.userDetailsService = userDetailsService;
        this.jwtUtil = jwtUtil;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader("Authorization");

        // Si las siguientes condiciones se cumplen, el usuario ha obtenido un token
        if(token != null && token.startsWith("Bearer ")){
            token = token.substring(7);  // Eliminar "Bearer "
            System.out.println("Token valido: "+ token);
            try{
            Claims claims = jwtUtil.validarToken(token);
            String username = claims.getSubject();
            String rol = (String) claims.get("rol");

            List<GrantedAuthority> authorities = List.of(new SimpleGrantedAuthority(rol));

            UsernamePasswordAuthenticationToken authentication =
                    new UsernamePasswordAuthenticationToken(username, null, authorities);

            SecurityContextHolder.getContext().setAuthentication(authentication);
                System.out.println("Usuario autenticado: "+ username + " con rol: " + rol);
            }catch (Exception e){
                System.out.println("Token invalido o expirado "+ e.getMessage());
            }
        }

        // Dejar pasar la solicitud
        filterChain.doFilter(request, response);
    }
}
