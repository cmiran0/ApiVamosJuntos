package app.controller;


import app.jpa.UsuarioRepo;
import app.modelo.Coche;
import app.modelo.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping(path = "/vamosJuntos/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepo usuarioRepo;

    @GetMapping
    public Iterable<Usuario> getUsers() {
        return usuarioRepo.findAll();
    }
    

    @GetMapping("/user")
    public Usuario getUser(@RequestParam String dni) {
        if (usuarioRepo.findByDni(dni)!=null) return usuarioRepo.findByDni(dni);
        else return null;
    }


    @PostMapping
    public String addUser(@RequestBody Usuario usuario) {
        if (usuarioRepo.findByDni(usuario.getDni()) == null) {
            usuarioRepo.save(usuario);
            return "Agregrado!";
        } else return "Ya existe!";
    }

    @DeleteMapping
    public String delUsers(){
        usuarioRepo.deleteAll();
        return "ok";
    }


}
