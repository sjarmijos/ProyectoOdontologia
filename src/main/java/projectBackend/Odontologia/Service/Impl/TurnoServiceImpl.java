package projectBackend.Odontologia.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projectBackend.Odontologia.Entity.Turno;
import projectBackend.Odontologia.Repository.TurnoRepository;
import projectBackend.Odontologia.Service.TurnoService;

import java.util.List;
import java.util.Optional;

@Service
public class TurnoServiceImpl implements TurnoService {

    @Autowired
    private TurnoRepository turnoRepository;

    @Override
    public Turno saveTurno(Turno turno) {
        return turnoRepository.save(turno);
    }

    @Override
    public void deleteTurno(Long id) {
        turnoRepository.deleteById(id);
    }

    @Override
    public Optional<Turno> getTurnoById(Long id) {
        return turnoRepository.findById(id);
    }

    @Override
    public Turno updateTurno(Turno turno) {
        return turnoRepository.save(turno);
    }

    @Override
    public List<Turno> getTurnos() {
        return turnoRepository.findAll();
    }
}
