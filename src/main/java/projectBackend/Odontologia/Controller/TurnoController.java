package projectBackend.Odontologia.Controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projectBackend.Odontologia.Entity.Odontologo;
import projectBackend.Odontologia.Entity.Paciente;
import projectBackend.Odontologia.Entity.Turno;
import projectBackend.Odontologia.Service.OdontologoService;
import projectBackend.Odontologia.Service.PacienteService;
import projectBackend.Odontologia.Service.TurnoService;
import projectBackend.Odontologia.exception.FailCreationException;
import projectBackend.Odontologia.exception.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/turno")
public class TurnoController {
    private static final Logger logger= Logger.getLogger(TurnoController.class);
    @Autowired
    private TurnoService turnoService;
    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private OdontologoService odontologoService;

    @PostMapping("/createTurno")
    public ResponseEntity<Turno> saveTurno(@RequestBody Turno turno) throws FailCreationException {
        Optional<Paciente> paciente = pacienteService.getPacienteById(turno.getPaciente().getId());
        Optional<Odontologo> odontologo = odontologoService.getOdontologoById(turno.getOdontologo().getId());
        if(paciente.isPresent() && odontologo.isPresent()) {
            turno.setPaciente(paciente.get());
            turno.setOdontologo(odontologo.get());
            Turno turnoGuardado = turnoService.saveTurno(turno);
            return ResponseEntity.ok(turnoGuardado);
        }else{
            logger.error("No se pudo crear el turno");
            throw new FailCreationException("No se pudo crear el turno");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTurno(@PathVariable("id") Long id) throws ResourceNotFoundException {
        Optional<Turno> turno = turnoService.getTurnoById(id);
        if (turno.isPresent()) {
            turnoService.deleteTurno(id);
            return ResponseEntity.ok("Turno eliminado correctamente");
        } else {
            logger.warn("Turno no encontrado");
            throw new ResourceNotFoundException("Turno no encontrado");
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Turno> getTurnoById(@PathVariable("id") Long id) throws ResourceNotFoundException {
        Optional<Turno> turno = turnoService.getTurnoById(id);
        if (turno.isPresent()) {
            return ResponseEntity.ok(turno.get());
        } else {
            logger.warn("Turno no encontrado");
            throw new ResourceNotFoundException("Turno no encontrado");
        }
    }

    @PutMapping
    public ResponseEntity<Turno> updateTurno(@RequestBody Turno turno) throws ResourceNotFoundException {
        Optional<Turno> turno1 = turnoService.getTurnoById(turno.getId());
        if (turno1.isEmpty()) {
            logger.warn("Turno no encontrado");
            throw new ResourceNotFoundException("Turno no encontrado");
        }
        return ResponseEntity.ok(turnoService.updateTurno(turno));
    }

    @GetMapping
    public ResponseEntity<List<Turno>> getTurnos() {
        return ResponseEntity.ok(turnoService.getTurnos());
    }

}
