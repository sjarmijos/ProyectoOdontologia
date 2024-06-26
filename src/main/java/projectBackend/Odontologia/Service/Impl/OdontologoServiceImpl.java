package projectBackend.Odontologia.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projectBackend.Odontologia.Entity.Odontologo;
import projectBackend.Odontologia.Repository.OdontologoRepository;
import projectBackend.Odontologia.Service.OdontologoService;

import java.util.List;
import java.util.Optional;

@Service
public class OdontologoServiceImpl implements OdontologoService {

    @Autowired
    private OdontologoRepository odontologoRepository;

    @Override
    public Odontologo saveOdontologo(Odontologo odontologo) {
        return odontologoRepository.save(odontologo);
    }

    @Override
    public void deleteOdontologo(Long id) {
        odontologoRepository.deleteById(id);
    }

    @Override
    public Optional<Odontologo> getOdontologoById(Long id) {
        return odontologoRepository.findById(id);
    }

    @Override
    public Optional<Odontologo> getOdontologoByMatricula(String matricula) {
        return odontologoRepository.findByMatricula(matricula);
    }

    @Override
    public Odontologo updateOdontologo(Odontologo odontologo) {
        return odontologoRepository.save(odontologo);
    }

    @Override
    public List<Odontologo> getOdontologos() {
        return odontologoRepository.findAll();
    }
}
