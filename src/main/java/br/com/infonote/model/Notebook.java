package br.com.infonote.model;

import jakarta.persistence.*;

@Entity
@Table(name = "notebooks")
public class Notebook {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String marca;
    private String modelo;
    private String serial;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    public Long getId(){return id;}
    public void setId(Long id){this.id=id;}
    public String getMarca(){return marca;}
    public void setMarca(String marca){this.marca=marca;}
    public String getModelo(){return modelo;}
    public void setModelo(String modelo){this.modelo=modelo;}
    public String getSerial(){return serial;}
    public void setSerial(String serial){this.serial=serial;}
    public Cliente getCliente(){return cliente;}
    public void setCliente(Cliente cliente){this.cliente=cliente;}
}
