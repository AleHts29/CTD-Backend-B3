package com.example.demo.MVC.controller;
import com.example.demo.MVC.dominio.Usuario;
import com.example.demo.MVC.services.UsuarioService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {
    private UsuarioService usuarioService = new UsuarioService();

    @GetMapping("/")
    public Usuario crearUsuario(){
        return usuarioService.crearUsuario();
    }

    @GetMapping("/newUser2")
    public Usuario crearUsuario2(){
        Usuario usuario = new Usuario("Juan", 45);
        return usuario;
    }
}
