package br.com.infonote.controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import br.com.infonote.service.RelatorioService;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/relatorio")
public class RelatorioController {
    @Autowired
    private RelatorioService rel;
    @GetMapping("/csv")
    public ResponseEntity<?> csv() {
        try {
            String path = rel.gerarCSV();
            return ResponseEntity.ok().body("CSV gerado em: " + path);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erro: " + e.getMessage());
        }
    }
}
