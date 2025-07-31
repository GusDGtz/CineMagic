package com.metaphorce.CineMagic.controladores;

import com.metaphorce.CineMagic.entidades.IngresoUsuario;
import com.metaphorce.CineMagic.entidades.Usuario;
import com.metaphorce.CineMagic.repositorios.UsuarioRepositorio;
import com.metaphorce.CineMagic.seguridad.JwtUtil;
import com.metaphorce.CineMagic.servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/CineMagic/auth")
public class AuthController {
    @Autowired
    UsuarioServicio servicio;
    @Autowired
    UsuarioRepositorio repositorio;
    @Autowired
    JwtUtil jwtUtil;
    private AuthenticationManager authenticationManager;

    @PostMapping("/registrarse")
    public ResponseEntity<?> registrarUsuario(@RequestBody Usuario usuario, @RequestParam Integer id_rol){
        if(repositorio.findByNombreUsuario(usuario.getUsername()).isPresent())
            return ResponseEntity.badRequest().body("El nombre de usuario ya existe");

        if(usuario.getNombreUsuario() == null)
            return ResponseEntity.badRequest().body("El nombre de usuario es nulo");
        if(usuario.getPassword() == null)
            return ResponseEntity.badRequest().body("La contrasena no puede ser nula");

        Usuario nuevoUsuario = servicio.crearUsuario(id_rol, usuario);
        String token = jwtUtil.generarToken(nuevoUsuario);
        return ResponseEntity.ok(token);
    }
    // LOGIN
    @PostMapping("/iniciar-sesion")
    public ResponseEntity <?> iniciarSesion(@RequestBody IngresoUsuario peticion){

        if(peticion == null)
            return ResponseEntity.badRequest().body("Peticion de ingreso nula");
        if(peticion.getNombreUsuario() == null || peticion.getNombreUsuario().isEmpty())
            return ResponseEntity.badRequest().body("Nombre de usuario nulo o vacio");
        if(peticion.getContrasenia() == null || peticion.getContrasenia().isEmpty())
            return ResponseEntity.badRequest().body("Contrasena nula o vacia");

        Usuario ingresado =  servicio.iniciarSesion(peticion);
        String token = jwtUtil.generarToken(ingresado);
        return ResponseEntity.ok(token);
    }

    @GetMapping("/usuarios")
    public ResponseEntity<?> obtenerUsuarios(){
        return ResponseEntity.ok(servicio.obtenerUsuarios());
    }

}
