package projectBackend.Odontologia.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Paciente> savePaciente(@RequestBody Paciente paciente) {
        return ResponseEntity.ok(pacienteService.savePaciente(paciente));
    }

    @DeleteMapping("/{id}")
    public void deletePaciente(@PathVariable("id") Long id) {
        pacienteService.deletePaciente(id);
    }

    @PutMapping
    public ResponseEntity<Paciente> updatePaciente(@RequestBody Paciente paciente) {
        Optional<Paciente> paciente1 = pacienteService.getPacienteById(paciente.getId());
        if (paciente1.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(pacienteService.updatePaciente(paciente));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> getPacientePorId(@PathVariable("id") Long id) {
        Optional<Paciente> paciente = pacienteService.getPacienteById(id);
        if (paciente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(paciente.get());
    }

    @GetMapping("/get/{email}")
    public ResponseEntity<Paciente> getPacientePorEmail(@PathVariable("email") String email) {
        Optional<Paciente> paciente = pacienteService.getPacienteByEmail(email);
        if (paciente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(paciente.get());
    }

    @GetMapping
    public ResponseEntity<List<Paciente>> getPacientes() {
        return ResponseEntity.ok(pacienteService.getPacientes());
    }

}
