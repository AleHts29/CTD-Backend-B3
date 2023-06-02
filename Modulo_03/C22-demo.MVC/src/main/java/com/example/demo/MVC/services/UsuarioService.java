package com.example.demo.MVC.services;

import com.example.demo.MVC.dominio.Usuario;

public class UsuarioService {

    public Usuario crearUsuario (){
        Usuario usuario = new Usuario("Ale", 36);
        return usuario;
    }
}
