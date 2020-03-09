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
    public Iterable<Coche> getCoches() {
        return cocheRepo.findAll();
    }

    @PostMapping
    private String addCoche(@RequestBody Coche coche, @RequestParam String dni) {
        if (cocheRepo.findByMatricula(coche.getMatricula()) == null) {
            coche.setPropietario(usuarioRepo.findByDni(dni));
            cocheRepo.save(coche);
            return "Guardado";
        } else return "Ya existe";
    }

    @PutMapping("/{matricula}")
    private String addPasajero(@RequestParam String dni,@PathVariable String matricula) {
        if (usuarioRepo.findByDni(dni) != null) {
            Usuario pasajero = usuarioRepo.findByDni(dni);
            if (cocheRepo.findByMatricula(matricula)!=null){
                Coche coche=  cocheRepo.findByMatricula(matricula);
                coche.addPasajero(pasajero);
                cocheRepo.save(coche);
                return "Ok";
            }else return "fail";
        }else return "fail";
    }


}
