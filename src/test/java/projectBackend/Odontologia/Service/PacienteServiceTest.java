package projectBackend.Odontologia.Service;


import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import projectBackend.Odontologia.Entity.Domicilio;
import projectBackend.Odontologia.Entity.Paciente;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PacienteServiceTest {
    @Autowired
    private PacienteService pacienteService;

    @Test
    @Order(1)
    public void guardarPaciente(){
        Paciente paciente= new Paciente(1L,"Jorgito","pereyra","11111", LocalDate.of(2024,6,20),new Domicilio(1L,"calle falsa","123","La Rioja","Argentina"),"jorge.pereyra@digitalhouse.com");
        Paciente pacienteGuardado= pacienteService.savePaciente(paciente);
        assertEquals(1L,pacienteGuardado.getId());
    }

    @Test
    @Order(2)
    public void buscarPacientePorId(){
        Long id= 1L;
        Optional<Paciente> pacienteBuscado= pacienteService.getPacienteById(id);
        assertNotNull(pacienteBuscado.get());
    }

    @Test
    @Order(3)
    public void actualizarPaciente(){
        Long id= 1L;
        Paciente paciente= new Paciente(id,"German","Fraire","11111", LocalDate.of(2024,6,20),new Domicilio(1L,"calle falsa","123","La Rioja","Argentina"),"jorge.pereyra@digitalhouse.com");
        pacienteService.updatePaciente(paciente);
        Optional<Paciente> pacienteBuscado= pacienteService.getPacienteById(id);
        assertEquals("German", pacienteBuscado.get().getNombre());
    }

   @Test
   @Order(4)
   public void ListarTodos(){
        List<Paciente> listaPacientes= pacienteService.getPacientes();
        assertEquals(1,listaPacientes.size());
   }
   @Test
    @Order(5)
    public void eliminarPaciente(){
        pacienteService.deletePaciente(1L);
        Optional<Paciente> pacienteEliminado= pacienteService.getPacienteById(1L);
        assertFalse(pacienteEliminado.isPresent());
   }
}
