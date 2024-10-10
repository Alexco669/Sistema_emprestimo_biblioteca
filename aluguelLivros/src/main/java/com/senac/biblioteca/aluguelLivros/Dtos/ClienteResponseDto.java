package com.senac.biblioteca.aluguelLivros.Dtos;

import com.senac.biblioteca.aluguelLivros.Models.Cliente;

public record ClienteResponseDto(Integer id, String nome, String email, String telefone, String Cpf, boolean apto) {
    public static ClienteResponseDto toDto(Cliente cliente){
        return new ClienteResponseDto(cliente.getId(), cliente.getNome(), cliente.getEmail(), cliente.getTelefone(), cliente.getCpf(), cliente.isApto());

    }
}
