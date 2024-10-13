package com.senac.biblioteca.aluguelLivros.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "exemplares_livros")
public class Exemplar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "referencia", nullable = false)
    private Integer referencia;
    @Column(name = "status",nullable = false)
    private boolean disponivel;
    @JoinColumn(name = "id_livro")
    @ManyToOne(fetch = FetchType.LAZY)
    private Livro livro;

    public Exemplar() {
    }

    public Exemplar(Integer id, Integer referencia, boolean disponivel, Livro livro) {
        this.id = id;
        this.referencia = referencia;
        this.disponivel = disponivel;
        this.livro = livro;
    }

    public Integer getId() {
        return id;
    }

    public Integer getReferencia() {
        return referencia;
    }

    public void setReferencia(Integer referencia) {
        this.referencia = referencia;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }
}
