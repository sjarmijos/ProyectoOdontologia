package projectBackend.Odontologia.Service;

import projectBackend.Odontologia.Entity.Turno;

import java.util.List;
import java.util.Optional;

public interface TurnoService {
    Turno saveTurno(Turno turno);
    void deleteTurno(Long id);

    Optional<Turno> getTurnoById(Long id);

    Turno updateTurno(Turno turno);
    List<Turno> getTurnos();
}
