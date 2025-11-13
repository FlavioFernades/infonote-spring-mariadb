package br.com.infonote.controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import br.com.infonote.repository.OrdemServicoRepository;
import br.com.infonote.model.OrdemServico;
import java.util.List;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/os")
public class OrdemServicoController {
    @Autowired
    private OrdemServicoRepository repo;

    @GetMapping public List<OrdemServico> listar(){ return repo.findAll(); }
    @PostMapping public ResponseEntity<?> criar(@RequestBody OrdemServico os){ repo.save(os); return ResponseEntity.ok().build(); }
    @PutMapping public ResponseEntity<?> atualizar(@RequestBody OrdemServico os){ repo.save(os); return ResponseEntity.ok().build(); }
    @GetMapping("/{id}") public OrdemServico obter(@PathVariable Long id){ return repo.findById(id).orElse(null); }
}
