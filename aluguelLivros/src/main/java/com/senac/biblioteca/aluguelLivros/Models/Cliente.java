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
    @Column(name = "cpf", nullable = false, length = 11)
    private String cpf;
    @Column(name = "email", nullable = false, length = 100)
    private String email;
    @Column(name = "telefone", nullable = false, length = 12)
    private String telefone;
    @Column(name = "status_cliente")
    private boolean apto;

}
