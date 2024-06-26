package projectBackend.Odontologia.Controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projectBackend.Odontologia.Entity.Paciente;
import projectBackend.Odontologia.Service.PacienteService;
import projectBackend.Odontologia.exception.DuplicateRegisterException;
import projectBackend.Odontologia.exception.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    private static final Logger logger= Logger.getLogger(PacienteController.class);
    @Autowired
    private PacienteService pacienteService;

    @PostMapping("/createPaciente")
    public ResponseEntity<Paciente> savePaciente(@RequestBody Paciente paciente) {
        pacienteService.getPacienteByEmail(paciente.getEmail()).ifPresent(p -> {
            logger.error("Ya existe un paciente con el email: " + p.getEmail());
            throw new DuplicateRegisterException("Ya existe un paciente con el email: " + p.getEmail());
        });
        return ResponseEntity.ok(pacienteService.savePaciente(paciente));
    }

    @DeleteMapping("/{id}")
    public void deletePaciente(@PathVariable("id") Long id) {
        pacienteService.getPacienteById(id).orElseThrow(() -> {
            logger.warn("Paciente no encontrado");
            throw new ResourceNotFoundException("Paciente no encontrado");
        });
        pacienteService.deletePaciente(id);
    }

    @PutMapping
    public ResponseEntity<Paciente> updatePaciente(@RequestBody Paciente paciente) {
        Optional<Paciente> paciente1 = pacienteService.getPacienteById(paciente.getId());
        if (paciente1.isEmpty()) {
            logger.warn("Paciente no encontrado");
            throw new ResourceNotFoundException("Paciente no encontrado");
        }
        return ResponseEntity.ok(pacienteService.updatePaciente(paciente));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> getPacientePorId(@PathVariable("id") Long id) {
        Optional<Paciente> paciente = pacienteService.getPacienteById(id);
        if (paciente.isEmpty()) {
            logger.warn("Paciente no encontrado por ID");
            throw new ResourceNotFoundException("Paciente no encontrado");
        }
        return ResponseEntity.ok(paciente.get());
    }

    @GetMapping("/get/{email}")
    public ResponseEntity<Paciente> getPacientePorEmail(@PathVariable("email") String email) {
        Optional<Paciente> paciente = pacienteService.getPacienteByEmail(email);
        if (paciente.isEmpty()) {
            logger.warn("Paciente no encontrado por email");
            throw new ResourceNotFoundException("Paciente no encontrado");
        }
        return ResponseEntity.ok(paciente.get());
    }

    @GetMapping
    public ResponseEntity<List<Paciente>> getPacientes() {
        return ResponseEntity.ok(pacienteService.getPacientes());
    }

}
