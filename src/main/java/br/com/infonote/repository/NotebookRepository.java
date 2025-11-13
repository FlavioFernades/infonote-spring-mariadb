package br.com.infonote.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.infonote.model.Notebook;
public interface NotebookRepository extends JpaRepository<Notebook, Long> { }
