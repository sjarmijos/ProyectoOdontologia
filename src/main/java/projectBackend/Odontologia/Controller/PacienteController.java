package projectBackend.Odontologia.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import projectBackend.Odontologia.Entity.Paciente;
import projectBackend.Odontologia.Service.PacienteService;

import java.util.List;

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

    @PutMapping("/{id}")
    public Paciente updatePaciente(@PathVariable("id") Integer id, @RequestBody Paciente paciente) {
        return pacienteService.updatePaciente(id, paciente);
    }

    @GetMapping("/{id}")
    public Paciente getPaciente(@PathVariable("id") Integer id) {
        return pacienteService.getPaciente(id);
    }

    @GetMapping("/all")
    public List<Paciente> getPacientes() {
        return pacienteService.getPacientes();
    }

}
