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
    @ManyToOne(fetch = FetchType.LAZY)
    private Cliente cliente;
    @Column(name = "data_emprestimo")
    private LocalDate data;

    public Emprestimo() {
    }

    public Emprestimo(Integer id, Exemplar exemplar, Cliente cliente, LocalDate data) {
        this.id = id;
        this.exemplar = exemplar;
        this.cliente = cliente;
        this.data = data;
    }

    public Integer getId() {
        return id;
    }

    public Exemplar getExemplar() {
        return exemplar;
    }

    public void setExemplar(Exemplar exemplar) {
        this.exemplar = exemplar;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
}
