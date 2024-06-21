package projectBackend.Odontologia.Service;

import org.springframework.stereotype.Service;
import projectBackend.Odontologia.Entity.Paciente;

import java.util.List;
import java.util.Optional;

public interface PacienteService {
    Paciente savePaciente(Paciente paciente);
    void deletePaciente(Integer id);

    Optional<Paciente> getPacienteByEmail(String email);
    Optional<Paciente> getPacienteById(Integer id);

    Paciente updatePaciente(Paciente paciente);
    List<Paciente> getPacientes();
}
