package projectBackend.Odontologia.Controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projectBackend.Odontologia.Entity.Odontologo;
import projectBackend.Odontologia.Service.OdontologoService;
import projectBackend.Odontologia.exception.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/odontologo")
public class OdontologoController {

    private static final Logger logger= Logger.getLogger(OdontologoController.class);
    @Autowired
    private OdontologoService odontologoService;

    @PostMapping("/createOdontologo")
    public ResponseEntity<Odontologo> createOdontologo(@RequestBody Odontologo odontologo) {
        odontologoService.getOdontologoByMatricula(odontologo.getMatricula()).ifPresent(o -> {
            logger.error("Ya existe un odontologo con la matricula: " + o.getMatricula());
            throw new ResourceNotFoundException("Ya existe un odontologo con la matricula: " + o.getMatricula());
        });
        return ResponseEntity.ok(odontologoService.saveOdontologo(odontologo));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Odontologo> buscarOdontologo(@PathVariable("id") Long id) {
        Optional<Odontologo> odontologo = odontologoService.getOdontologoById(id);
        if (odontologo.isEmpty()) {
            logger.warn("Odontologo no encontrado por ID");
            throw new ResourceNotFoundException("Odontologo no encontrado");
        }
        return ResponseEntity.ok(odontologo.get());
    }

    @GetMapping
    public ResponseEntity<List<Odontologo>> getOdontologos() {
        return ResponseEntity.ok(odontologoService.getOdontologos());
    }

    @DeleteMapping("/{id}")
    public void deleteOdontologo(@PathVariable("id") Long id) {
        odontologoService.getOdontologoById(id).orElseThrow(() -> {
            logger.warn("Odontologo no encontrado");
            throw new ResourceNotFoundException("Odontologo no encontrado");
        });
        odontologoService.deleteOdontologo(id);
    }

    @PutMapping
    public ResponseEntity<Odontologo> updateOdontologo(@RequestBody Odontologo odontologo) {
        Optional<Odontologo> odontologo1 = odontologoService.getOdontologoById(odontologo.getId());
        if (odontologo1.isEmpty()) {
            logger.warn("Odontologo no encontrado");
            throw new ResourceNotFoundException("Odontologo no encontrado");
        }
        return ResponseEntity.ok(odontologoService.updateOdontologo(odontologo));
    }


}
