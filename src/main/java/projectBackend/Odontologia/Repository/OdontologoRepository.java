package projectBackend.Odontologia.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projectBackend.Odontologia.Entity.Odontologo;

import java.util.Optional;

public interface OdontologoRepository extends JpaRepository<Odontologo, Long> {
    Optional<Odontologo> findByMatricula(String matricula);
}
