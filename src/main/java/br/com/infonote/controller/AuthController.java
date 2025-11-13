package br.com.infonote.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;
import br.com.infonote.service.AuthService;
import br.com.infonote.model.Usuario;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService auth;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam String username, @RequestParam String password, HttpSession session) {
        System.out.println("Tentando login com usuário: " + username);
        Usuario u = auth.login(username, password);
        if (u != null) {
            System.out.println("✅ Login bem-sucedido: " + username);
            session.setAttribute("user", u);
            return ResponseEntity.ok(u.getRole());
        }
        System.out.println("❌ Falha no login: credenciais inválidas.");
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas");
    }
}
