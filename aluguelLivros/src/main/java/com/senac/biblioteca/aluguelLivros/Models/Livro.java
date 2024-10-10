package com.senac.biblioteca.aluguelLivros.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "livros")
public class Livro {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    @Column(name = "titulo", nullable = false, length = 100)
    private String titulo;

    @Column(name = "autor", nullable = false, length = 150)
    private String autor;

    @Column(name = "anoPublicacao", nullable = false)
    private Integer anoPublicacao;
    @Column(name = "ISBN", nullable = false)
    private Integer ISBN;
    @Column(name = "Categoria", nullable = true)
    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    public Livro(Integer id, String titulo, String autor, Integer anoPublicacao, Integer ISBN, Categoria categoria) {
        Id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.ISBN = ISBN;
        this.categoria = categoria;
    }

    public Livro() {
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Integer getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(Integer anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public Integer getISBN() {
        return ISBN;
    }

    public void setISBN(Integer ISBN) {
        this.ISBN = ISBN;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
