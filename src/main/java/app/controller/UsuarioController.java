package app.controller;

import app.jpa.CocheRepo;
import app.jpa.EventoRepo;
import app.jpa.UsuarioRepo;
import app.modelo.Coche;
import app.modelo.Evento;
import app.modelo.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/vamosJuntos/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepo usuarioRepo;
    @Autowired
    private CocheRepo cocheRepo;

    @GetMapping("/{dni}")
    public Iterable<Coche> getCocheByPropietario(@PathVariable String dni){
        return cocheRepo.findAllByPropietario(usuarioRepo.findAllByDni(dni));

    }

    @GetMapping
    public Iterable<Usuario> getUsuarios() {
        return usuarioRepo.findAll();
    }


    @PostMapping
    public void addUser(@RequestBody Usuario usuario) {
        if (usuarioRepo.findAllByDni(usuario.getDni()) == null) usuarioRepo.save(usuario);
    }

    @DeleteMapping
    public void delUsers() {
        usuarioRepo.deleteAll();
    }


}
