package projectBackend.Odontologia.Service;

import projectBackend.Odontologia.Entity.Usuario;

public interface UsuarioService {
    Usuario save(Usuario usuario) throws Exception;
    Usuario getUsuario(String username);
    Iterable<Usuario> getUsuarios();
    void deleteUsuario(Long id);

}
