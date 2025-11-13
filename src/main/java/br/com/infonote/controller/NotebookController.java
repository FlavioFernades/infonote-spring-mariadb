package br.com.infonote.controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import br.com.infonote.repository.NotebookRepository;
import br.com.infonote.model.Notebook;
import java.util.List;

@RestController
@RequestMapping("/api/notebooks")
public class NotebookController {
    @Autowired
    private NotebookRepository repo;
    @GetMapping public List<Notebook> listar(){ return repo.findAll(); }
    @PostMapping public Notebook criar(@RequestBody Notebook n){ return repo.save(n); }
    @GetMapping("/{id}") public Notebook obter(@PathVariable Long id){ return repo.findById(id).orElse(null); }
    @DeleteMapping("/{id}") public void excluir(@PathVariable Long id){ repo.deleteById(id); }
}
