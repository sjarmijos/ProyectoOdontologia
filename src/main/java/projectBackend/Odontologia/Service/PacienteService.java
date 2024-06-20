package projectBackend.Odontologia.Service;

import org.springframework.stereotype.Service;
import projectBackend.Odontologia.Entity.Paciente;

import java.util.List;

@Service
public interface PacienteService {
    Paciente savePaciente(Paciente paciente);
    void deletePaciente(Integer id);
    Paciente getPaciente(Integer id);
    Paciente updatePaciente(Integer id, Paciente paciente);
    List<Paciente> getPacientes();
}
