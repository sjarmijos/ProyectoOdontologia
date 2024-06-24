package projectBackend.Odontologia.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projectBackend.Odontologia.Entity.Usuario;
import projectBackend.Odontologia.Repository.UsuarioRepository;
import projectBackend.Odontologia.Service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;


    @Override
    public Usuario save(Usuario usuario) throws Exception{
        Usuario usuarioLocal = usuarioRepository.findByUsername(usuario.getUsername());
        if(usuarioLocal != null){
            System.out.println("El usuario ya existe");
            throw new Exception("El usuario ya esta presente");
        }
        else{
            usuarioLocal = usuarioRepository.save(usuario);
        }
        return usuarioLocal;
    }

    @Override
    public Usuario getUsuario(String username) {
        return usuarioRepository.findByUsername(username);
    }

    @Override
    public Iterable<Usuario> getUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public void deleteUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
}
