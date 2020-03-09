package app.jpa;

import app.modelo.Coche;
import app.modelo.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CocheRepo extends CrudRepository<Coche, Long> {
Coche findByMatricula(String matricula);

}
