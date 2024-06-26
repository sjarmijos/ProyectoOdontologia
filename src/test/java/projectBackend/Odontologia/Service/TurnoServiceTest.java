package projectBackend.Odontologia.Service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import projectBackend.Odontologia.Entity.Domicilio;
import projectBackend.Odontologia.Entity.Odontologo;
import projectBackend.Odontologia.Entity.Paciente;
import projectBackend.Odontologia.Entity.Turno;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TurnoServiceTest {

    @Autowired
    private TurnoService turnoService;
    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private OdontologoService odontologoService;

    @Test
    @Order(1)
    public void guardarTurno() {
        Paciente paciente = new Paciente(1L, "Jorgito", "pereyra", "11111", LocalDate.of(2024, 6, 20), new Domicilio(1L, "calle falsa", "123", "La Rioja", "Argentina"), "jorge.pereyra@digitalhouse.com");
        Odontologo odontologo = new Odontologo(1L, "Manuel", "Perez", "123asd");
        pacienteService.savePaciente(paciente);
        odontologoService.saveOdontologo(odontologo);
        Turno turno = new Turno(1L, paciente, odontologo, LocalDate.of(2024, 6, 20));
        Turno turnoGuardado = turnoService.saveTurno(turno);
        assertEquals(1L, turnoGuardado.getId());
    }

    @Test
    @Order(2)
    public void buscarTurnoPorId() {
        Long id = 1L;
        Optional<Turno> turnoBuscado = turnoService.getTurnoById(id);
        assertNotNull(turnoBuscado);
    }

    @Test
    @Order(3)
    public void actualizarTurno() {
        Long id = 1L;
        Paciente paciente = new Paciente(1L, "Jorgito", "pereyra", "11111", LocalDate.of(2024, 6, 20), new Domicilio(1L, "calle falsa", "123", "La Rioja", "Argentina"), "jorge.pereyra@digitalhouse.com");
        Odontologo odontologo = new Odontologo(1L, "Manuel", "Perez", "123asd");
        Turno turno = new Turno(1L, paciente, odontologo, LocalDate.of(2025, 6, 20));
        turnoService.updateTurno(turno);
        assertEquals(LocalDate.of(2025, 6, 20), turno.getFecha());
    }

    @Test
    @Order(4)
    public void listarTodos() {
        assertEquals(1, turnoService.getTurnos().size());
    }

    @Test
    @Order(5)
    public void eliminarTurno() {
        turnoService.deleteTurno(1L);
        assertEquals(0, turnoService.getTurnos().size());
    }
}
