package projectBackend.Odontologia.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import projectBackend.Odontologia.Entity.Usuario;
import projectBackend.Odontologia.Entity.UsuarioRole;
import projectBackend.Odontologia.Repository.UsuarioRepository;

@Component
public class DatosIniciales implements ApplicationRunner {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        String passSinCifrar= "admin";
        String passCifrado=  passwordEncoder.encode(passSinCifrar);
        Usuario usuario= new Usuario("jorgito","jpereryradh","admin@admin.com",passCifrado, UsuarioRole.ROLE_ADMIN);
        usuarioRepository.save(usuario);

        String passSinCifrar2= "user";
        String passCifrado2=  passwordEncoder.encode(passSinCifrar2);
        Usuario usuario2= new Usuario("jorgito2","jpereryradh2","user@user.com",passCifrado2, UsuarioRole.ROLE_USER);
        usuarioRepository.save(usuario2);
    }
}
