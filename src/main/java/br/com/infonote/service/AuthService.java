package br.com.infonote.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import br.com.infonote.repository.UsuarioRepository;
import br.com.infonote.model.Usuario;

@Service
public class AuthService {

    @Autowired
    private UsuarioRepository usuarioRepo;

    public Usuario login(String username, String password) {
        System.out.println("Tentando login com usuário: " + username);

        return usuarioRepo.findByUsername(username)
                .map(u -> {
                    System.out.println("Usuário encontrado: " + u.getUsername());
                    System.out.println("Hash no banco: " + u.getPassword());
                    boolean match = new BCryptPasswordEncoder().matches(password, u.getPassword());
                    System.out.println("Senha informada: " + password);
                    System.out.println("Senha confere? " + match);
                    return match ? u : null;
                })
                .orElseGet(() -> {
                    System.out.println("Usuário não encontrado no banco.");
                    return null;
                });
    }

	public void register(String username, String password, String role) {
		// TODO Auto-generated method stub
		
	}

}
