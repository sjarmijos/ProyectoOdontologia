package projectBackend.Odontologia.Service.Impl;

import projectBackend.Odontologia.Entity.Domicilio;
import projectBackend.Odontologia.Repository.DomicilioRepository;
import projectBackend.Odontologia.Service.DomicilioService;

import java.util.List;

public class DomicilioServiceImpl implements DomicilioService {

    private DomicilioRepository domicilioRepository;

    @Override
    public Domicilio saveDomicilio(Domicilio domicilio) {
        return domicilioRepository.save(domicilio);
    }

    @Override
    public void deleteDomicilio(Integer id) {
        domicilioRepository.deleteById(id);
    }

    @Override
    public Domicilio getDomicilio(Integer id) {
        return domicilioRepository.findById(id).orElseThrow(() -> new RuntimeException("Domicilio no encontrado"));
    }

    @Override
    public Domicilio updateDomicilio(Integer id, Domicilio domicilio) {
        Domicilio domicilioEncontrado = getDomicilio(id);
        domicilioEncontrado.setCalle(domicilio.getCalle());
        domicilioEncontrado.setNumero(domicilio.getNumero());
        domicilioEncontrado.setLocalidad(domicilio.getLocalidad());
        domicilioEncontrado.setProvincia(domicilio.getProvincia());
        return domicilioRepository.save(domicilioEncontrado);
    }

    @Override
    public List<Domicilio> getDomicilios() {
        return domicilioRepository.findAll();
    }
}
