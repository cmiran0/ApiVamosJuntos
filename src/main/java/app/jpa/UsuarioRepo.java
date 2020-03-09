package app.jpa;

import app.modelo.Coche;
import app.modelo.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepo extends CrudRepository<Usuario, Long> {
    Usuario findByDni(String dni);

}
