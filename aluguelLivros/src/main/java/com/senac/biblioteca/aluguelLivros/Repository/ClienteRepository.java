package com.senac.biblioteca.aluguelLivros.Repository;

import com.senac.biblioteca.aluguelLivros.Models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
