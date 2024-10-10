package com.senac.biblioteca.aluguelLivros.Dtos;

import com.senac.biblioteca.aluguelLivros.Models.Cliente;

public record ClienteRequestDto(String nome, String cpf, String telefone, String email, boolean apto) {

    public Cliente toCliente(Cliente cliente){
        cliente.setNome(this.nome());
        cliente.setEmail(this.email);
        cliente.setApto(this.apto);
        cliente.setCpf(this.cpf);
        cliente.setTelefone(this.telefone);

        return cliente;
    }

}
