package app.jpa;

import app.modelo.Evento;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventoRepo extends CrudRepository<Evento, Long> {


}
