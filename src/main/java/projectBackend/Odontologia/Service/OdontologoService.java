package projectBackend.Odontologia.Service;

import projectBackend.Odontologia.Entity.Odontologo;

import java.util.List;
import java.util.Optional;

public interface OdontologoService {
    Odontologo saveOdontologo(Odontologo odontologo);
    void deleteOdontologo(Long id);

    Optional<Odontologo> getOdontologoById(Long id);

    Odontologo updateOdontologo(Odontologo odontologo);
    List<Odontologo> getOdontologos();
}
