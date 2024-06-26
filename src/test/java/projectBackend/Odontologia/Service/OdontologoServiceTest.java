package projectBackend.Odontologia.Service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import projectBackend.Odontologia.Entity.Odontologo;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OdontologoServiceTest {
    @Autowired
    private OdontologoService odontologoService;

    @Test
    @Order(1)
    public void guardarOdontologo(){
        Odontologo odontologo = new Odontologo(1L, "Juan", "Perez", "123asd");
        Odontologo odontologoGuardado = odontologoService.saveOdontologo(odontologo);
        assertEquals(1L, odontologoGuardado.getId());
    }

    @Test
    @Order(2)
    public void buscarOdontologoPorId(){
        Long id = 1L;
        Optional<Odontologo> odontologoBuscado = odontologoService.getOdontologoById(id);
        assertNotNull(odontologoBuscado);
    }

    @Test
    @Order(3)
    public void actualizarOdontologo(){
        Long id = 1L;
        Odontologo odontologo = new Odontologo(id, "Manuel", "Perez", "123asd");
        odontologoService.updateOdontologo(odontologo);
        Optional<Odontologo> odontologoBuscado = odontologoService.getOdontologoById(id);
        assertEquals("Manuel", odontologoBuscado.get().getNombre());
    }

    @Test
    @Order(4)
    public void listarTodos(){
        assertEquals(1, odontologoService.getOdontologos().size());
    }

    @Test
    @Order(5)
    public void eliminarOdontologo(){
        odontologoService.deleteOdontologo(1L);
        assertEquals(0, odontologoService.getOdontologos().size());
    }
}
