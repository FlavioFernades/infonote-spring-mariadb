package br.com.infonote.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.infonote.model.Cliente;
public interface ClienteRepository extends JpaRepository<Cliente, Long> { }
