package com.senac.biblioteca.aluguelLivros.Models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "emprestimos")
public class Emprestimo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "id_exemplar")
    @ManyToOne(fetch = FetchType.LAZY)
    private Exemplar exemplar;
    @JoinColumn(name = "id_cliente")
    @OneToOne(fetch = FetchType.LAZY)
    private Cliente cliente;
    @Column(name = "data_emprestimo")
    private LocalDate data;
}
