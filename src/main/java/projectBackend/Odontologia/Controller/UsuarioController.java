package projectBackend.Odontologia.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import projectBackend.Odontologia.Entity.Usuario;
import projectBackend.Odontologia.Service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin("*")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/signup")
    public Usuario guardarUsuario(@RequestBody Usuario usuario) throws Exception{
        usuario.setPassword(this.bCryptPasswordEncoder.encode(usuario.getPassword()));
        return usuarioService.save(usuario);
    }

    @GetMapping("/{username}")
    public Usuario obtenerUsuario(@PathVariable("username") String username){
        return usuarioService.getUsuario(username);
    }

    @DeleteMapping("/{usuarioId}")
    public void eliminarUsuario(@PathVariable("usuarioId") Long usuarioId){
        usuarioService.deleteUsuario(usuarioId);
    }

    @GetMapping
    public Iterable<Usuario> getUsuarios(){
        return usuarioService.getUsuarios();
    }

}
