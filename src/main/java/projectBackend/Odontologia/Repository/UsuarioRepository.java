package projectBackend.Odontologia.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projectBackend.Odontologia.Entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,Long>{
    Usuario findByUsername(String username);
}
