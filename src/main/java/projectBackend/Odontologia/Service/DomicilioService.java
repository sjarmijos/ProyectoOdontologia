package projectBackend.Odontologia.Service;

import org.springframework.stereotype.Service;
import projectBackend.Odontologia.Entity.Domicilio;

import java.util.List;

@Service
public interface DomicilioService {
    Domicilio saveDomicilio(Domicilio domicilio);
    void deleteDomicilio(Integer id);
    Domicilio getDomicilio(Integer id);
    Domicilio updateDomicilio(Integer id, Domicilio domicilio);
    List<Domicilio> getDomicilios();

}
