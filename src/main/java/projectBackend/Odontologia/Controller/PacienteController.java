package projectBackend.Odontologia.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import projectBackend.Odontologia.Entity.Paciente;
import projectBackend.Odontologia.Service.PacienteService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/paciente")
public class PacienteController {
    @Autowired
    private PacienteService pacienteService;

    @PostMapping("/createPaciente")
    public Paciente savePaciente(@RequestBody Paciente paciente) {
        return pacienteService.savePaciente(paciente);
    }

    @DeleteMapping("/{id}")
    public void deletePaciente(@PathVariable("id") Integer id) {
        pacienteService.deletePaciente(id);
    }

    @PutMapping
    public Paciente updatePaciente(@RequestBody Paciente paciente) {
        Optional<Paciente> paciente1 = pacienteService.getPacienteById(paciente.getId());
        if (paciente1.isEmpty()) {
            throw new RuntimeException("Paciente no encontrado");
        }
        return pacienteService.updatePaciente(paciente);
    }

    @GetMapping("/{id}")
    public Paciente getPacientePorId(@PathVariable("id") Integer id) {
        return pacienteService.getPacienteById(id).get();
    }

    @GetMapping("/{email}")
    public Paciente getPacientePorEmail(@PathVariable("email") String email) {
        return pacienteService.getPacienteByEmail(email).get();
    }

    @GetMapping
    public List<Paciente> getPacientes() {
        return pacienteService.getPacientes();
    }

}
