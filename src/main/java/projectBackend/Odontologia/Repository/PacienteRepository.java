package projectBackend.Odontologia.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projectBackend.Odontologia.Entity.Paciente;

import java.util.Optional;

public interface PacienteRepository extends JpaRepository<Paciente, Long>{
    Optional<Paciente> findByEmail(String email);
}
