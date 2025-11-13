package br.com.infonote.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import br.com.infonote.repository.OrdemServicoRepository;
import br.com.infonote.model.OrdemServico;
import java.util.List;
import java.nio.file.*;

@Service
public class RelatorioService {
    @Autowired
    private OrdemServicoRepository repo;

    public String gerarCSV() throws Exception {
        List<OrdemServico> ordens = repo.findAll();
        StringBuilder sb = new StringBuilder("ID;Descricao;Status;DataAbertura\n");
        for (OrdemServico o : ordens) {
            sb.append(o.getId()).append(";").append(o.getDescricao()).append(";").append(o.getStatus()).append(";").append(o.getDataAbertura()).append("\n");
        }
        Path p = Paths.get("relatorio_os.csv");
        Files.write(p, sb.toString().getBytes());
        return p.toAbsolutePath().toString();
    }
}
