package projectBackend.Odontologia.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projectBackend.Odontologia.Entity.Turno;
import projectBackend.Odontologia.Service.TurnoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/turno")
public class TurnoController {
    @Autowired
    private TurnoService turnoService;

    @PostMapping("/createTurno")
    public ResponseEntity<Turno> saveTurno(@RequestBody Turno turno) {
        return ResponseEntity.ok(turnoService.saveTurno(turno));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTurno(@PathVariable("id") Long id) {
        Optional<Turno> turno = turnoService.getTurnoById(id);
        if (turno.isPresent()) {
            turnoService.deleteTurno(id);
            return ResponseEntity.ok("Turno eliminado correctamente");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Turno> getTurnoById(@PathVariable("id") Long id) {
        Optional<Turno> turno = turnoService.getTurnoById(id);
        if (turno.isPresent()) {
            return ResponseEntity.ok(turno.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping
    public ResponseEntity<Turno> updateTurno(@RequestBody Turno turno) {
        Optional<Turno> turno1 = turnoService.getTurnoById(turno.getId());
        if (turno1.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(turnoService.updateTurno(turno));
    }

    @GetMapping
    public ResponseEntity<List<Turno>> getTurnos() {
        return ResponseEntity.ok(turnoService.getTurnos());
    }

}
