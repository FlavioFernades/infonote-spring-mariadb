package br.com.infonote.controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import br.com.infonote.repository.ClienteRepository;
import br.com.infonote.model.Cliente;
import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    @Autowired
    private ClienteRepository repo;
    @GetMapping public List<Cliente> listar(){ return repo.findAll(); }
    @PostMapping public Cliente criar(@RequestBody Cliente c){ return repo.save(c); }
    @GetMapping("/{id}") public Cliente obter(@PathVariable Long id){ return repo.findById(id).orElse(null); }
    @DeleteMapping("/{id}") public void excluir(@PathVariable Long id){ repo.deleteById(id); }
}
