package com.senac.biblioteca.aluguelLivros.Repository;

import com.senac.biblioteca.aluguelLivros.Models.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Integer> {
}
