package projectBackend.Odontologia.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projectBackend.Odontologia.Entity.Usuario;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario,Long>{
    Usuario findByUserName(String username);
    Optional<Usuario> findByEmail(String email);
}
