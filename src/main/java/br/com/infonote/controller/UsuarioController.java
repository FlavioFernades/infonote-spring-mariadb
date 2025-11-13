package br.com.infonote.controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import br.com.infonote.repository.UsuarioRepository;
import br.com.infonote.model.Usuario;
import br.com.infonote.service.AuthService;
import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioRepository repo;
    @Autowired
    private AuthService auth;

    @GetMapping
    public List<Usuario> listar(){ return repo.findAll(); }

    @PostMapping
    public Usuario criar(@RequestBody Usuario u){ auth.register(u.getUsername(), u.getPassword(), u.getRole()); return u; }
}
