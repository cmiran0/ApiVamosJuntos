package app.controller;

import app.jpa.CocheRepo;
import app.jpa.UsuarioRepo;
import app.modelo.Coche;
import app.modelo.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/vamosJuntos/coche")
public class CocheController {

    @Autowired
    private CocheRepo cocheRepo;
    @Autowired
    private UsuarioRepo usuarioRepo;

    @GetMapping
    private Iterable<Coche> getCoches() {
        return cocheRepo.findAll();
    }


    @PostMapping
    private void addCoche(@RequestBody Coche coche, @RequestParam String dni) {
        if (cocheRepo.findAllByMatricula(coche.getMatricula()) == null && usuarioRepo.findAllByDni(dni) != null) {
            coche.setPropietario(usuarioRepo.findAllByDni(dni));
            cocheRepo.save(coche);
        }
    }

    @PutMapping("/{dni}/{matricula}")
    private void addPasajeros(@PathVariable String dni, @PathVariable String matricula) {
        if (cocheRepo.findAllByMatricula(matricula) == null && usuarioRepo.findAllByDni(dni) != null) {
            Coche coche = cocheRepo.findAllByMatricula(matricula);
            coche.getPasajeros().add(usuarioRepo.findAllByDni(dni));
            cocheRepo.save(coche);
        }
    }


}
