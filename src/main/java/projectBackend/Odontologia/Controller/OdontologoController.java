package projectBackend.Odontologia.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projectBackend.Odontologia.Entity.Odontologo;
import projectBackend.Odontologia.Service.OdontologoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {
    @Autowired
    private OdontologoService odontologoService;

    @PostMapping("/createOdontologo")
    public ResponseEntity<Odontologo> createOdontologo(Odontologo odontologo) {
        return ResponseEntity.ok(odontologoService.saveOdontologo(odontologo));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Odontologo> buscarOdontologo(Long id) {
        Optional<Odontologo> odontologo = odontologoService.getOdontologoById(id);
        if (odontologo.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(odontologo.get());
    }

    @GetMapping
    public ResponseEntity<List<Odontologo>> getOdontologos() {
        return ResponseEntity.ok(odontologoService.getOdontologos());
    }

    @DeleteMapping("/{id}")
    public void deleteOdontologo(Long id) {
        odontologoService.deleteOdontologo(id);
    }

    @PutMapping
    public ResponseEntity<Odontologo> updateOdontologo(Odontologo odontologo) {
        Optional<Odontologo> odontologo1 = odontologoService.getOdontologoById(odontologo.getId());
        if (odontologo1.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(odontologoService.updateOdontologo(odontologo));
    }


}
