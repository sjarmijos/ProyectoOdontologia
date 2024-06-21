package projectBackend.Odontologia.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projectBackend.Odontologia.Entity.Domicilio;
import projectBackend.Odontologia.Entity.Paciente;
import projectBackend.Odontologia.Repository.PacienteRepository;
import projectBackend.Odontologia.Service.PacienteService;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteServiceImpl implements PacienteService {
    @Autowired
    private PacienteRepository pacienteRepository;

    public Paciente savePaciente(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    public void deletePaciente(Integer id) {
        pacienteRepository.deleteById(id);
    }

    public Paciente getPaciente(Integer id) {
        return pacienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Paciente no encontrado"));
    }

    public Optional<Paciente> getPacienteById(Integer id) {
        return pacienteRepository.findById(id);
    }

    public Optional<Paciente> getPacienteByEmail(String email) {
        return pacienteRepository.findByEmail(email);
    }

    public Paciente updatePaciente(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    public List<Paciente> getPacientes() {
        return pacienteRepository.findAll();
    }

}
