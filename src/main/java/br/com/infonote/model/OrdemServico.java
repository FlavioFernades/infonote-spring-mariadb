package br.com.infonote.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ordens_servico")
public class OrdemServico {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    private String status; // ABERTA, EM_REPARO, CONCLUIDA
    private LocalDateTime dataAbertura;
    @ManyToOne
    @JoinColumn(name = "notebook_id")
    private Notebook notebook;
    @ManyToOne
    @JoinColumn(name = "tecnico_id")
    private Usuario tecnico;

    public OrdemServico(){ this.dataAbertura = LocalDateTime.now(); this.status = "ABERTA"; }

    public Long getId(){return id;}
    public void setId(Long id){this.id=id;}
    public String getDescricao(){return descricao;}
    public void setDescricao(String descricao){this.descricao=descricao;}
    public String getStatus(){return status;}
    public void setStatus(String status){this.status=status;}
    public LocalDateTime getDataAbertura(){return dataAbertura;}
    public void setDataAbertura(LocalDateTime dataAbertura){this.dataAbertura=dataAbertura;}
    public Notebook getNotebook(){return notebook;}
    public void setNotebook(Notebook notebook){this.notebook=notebook;}
    public Usuario getTecnico(){return tecnico;}
    public void setTecnico(Usuario tecnico){this.tecnico=tecnico;}
}
