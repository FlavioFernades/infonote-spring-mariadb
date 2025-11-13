package br.com.infonote;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.infonote.model.Usuario;
import br.com.infonote.repository.UsuarioRepository;

@SpringBootApplication
public class InfoNoteApplication {

    public static void main(String[] args) {
        SpringApplication.run(InfoNoteApplication.class, args);
    }

    @Bean
    public CommandLineRunner data(UsuarioRepository usuarioRepository) {
        return args -> {
            if (usuarioRepository.findByUsername("admin").isEmpty()) {
                Usuario u = new Usuario();
                u.setUsername("admin");
                u.setRole("ROLE_ADMIN");
                u.setPassword(new BCryptPasswordEncoder().encode("admin123"));
                usuarioRepository.save(u);
                System.out.println("Usuário admin criado: admin / admin123");
            }
        };
    }
}
