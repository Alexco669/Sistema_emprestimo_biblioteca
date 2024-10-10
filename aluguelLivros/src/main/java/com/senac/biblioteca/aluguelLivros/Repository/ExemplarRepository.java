package com.senac.biblioteca.aluguelLivros.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.senac.biblioteca.aluguelLivros.Models.Exemplar;

public interface ExemplarRepository extends JpaRepository<Exemplar, Integer> {
}
