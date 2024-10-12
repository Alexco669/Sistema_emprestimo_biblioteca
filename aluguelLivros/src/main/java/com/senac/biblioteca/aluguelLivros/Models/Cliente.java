package com.senac.biblioteca.aluguelLivros.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nome", nullable = false, length = 50)
    private String nome;
    @Column(name = "cpf", nullable = false, length = 11, unique = true)
    private String cpf;
    @Column(name = "email", nullable = false, length = 100)
    private String email;
    @Column(name = "telefone", nullable = false, length = 12)
    private String telefone;
    @Column(name = "status_cliente")
    private boolean apto;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public boolean isApto() {
        return apto;
    }

    public void setApto(boolean apto) {
        this.apto = apto;
    }

    public Integer getId() {
        return id;
    }

    public Cliente() {
    }

    public Cliente(Integer id, String nome, String cpf, String email, String telefone, boolean apto) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.apto = apto;
    }
}
