package com.senac.biblioteca.aluguelLivros.Repository;

import com.senac.biblioteca.aluguelLivros.Models.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Integer> {
}
