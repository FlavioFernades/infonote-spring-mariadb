-- initial data for InfoNote
INSERT INTO usuarios (username, password, role) VALUES ('admin', '$2a$10$dxRY9T3EwYqNRt1TovwN9eH4mTj2YHzCS3l8ZOrIx/4YQd3KQ8bca', 'ROLE_ADMIN');
INSERT INTO clientes (nome, cpf, telefone, email) VALUES ('Carlos da Silva', '12345678901', '(84) 99999-8888', 'carlos@exemplo.com');
-- notebooks: client id will be 1
INSERT INTO notebooks (marca, modelo, serial, cliente_id) VALUES ('Dell','Inspiron 15','ABC12345',1);
INSERT INTO ordens_servico (descricao, status, data_abertura, notebook_id, tecnico_id) VALUES ('Troca de teclado e limpeza interna','ABERTA', NOW(), 1, 1);
