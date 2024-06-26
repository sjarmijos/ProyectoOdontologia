package projectBackend.Odontologia.Service;

import projectBackend.Odontologia.Entity.Odontologo;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface OdontologoService {
    Odontologo saveOdontologo(Odontologo odontologo);
    void deleteOdontologo(Long id);

    Optional<Odontologo> getOdontologoById(Long id);

    Optional<Odontologo> getOdontologoByMatricula(String matricula);

    Odontologo updateOdontologo(Odontologo odontologo);
    List<Odontologo> getOdontologos();
}
