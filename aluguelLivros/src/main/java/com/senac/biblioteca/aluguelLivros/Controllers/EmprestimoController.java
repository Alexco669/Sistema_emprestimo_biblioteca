package com.senac.biblioteca.aluguelLivros.Controllers;

import com.senac.biblioteca.aluguelLivros.Models.Emprestimo;
import com.senac.biblioteca.aluguelLivros.Repository.ClienteRepository;
import com.senac.biblioteca.aluguelLivros.Repository.EmprestimoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("emprestimo_livro")
public class EmprestimoController {

    private final EmprestimoRepository emprestimoRepository;

    public EmprestimoController(EmprestimoRepository emprestimoRepository) {
        this.emprestimoRepository = emprestimoRepository;
    }


    @GetMapping
    public Page<Emprestimo> findAll(@RequestParam(name="numeroPagina", required = false, defaultValue = "0") int numeroPagina,
                                    @RequestParam(name = "quantidade", required = false, defaultValue = "5") int quantidadeRegistro) {
        PageRequest pageRequest = PageRequest.of(numeroPagina,quantidadeRegistro);
        return emprestimoRepository.findAll(pageRequest);
    }

    @GetMapping({"id"})
    public Emprestimo findById(@PathVariable("id") Integer id){
        Optional<Emprestimo> emprestimoOptional = emprestimoRepository.findById(id);

        if(emprestimoOptional.isPresent()){
            return emprestimoOptional.get();
        }else {
            throw new EntityNotFoundException("Empréstimo não encontrado");
        }
    }

    @PostMapping
    public Emprestimo save(@RequestBody Emprestimo emprestimo){
        emprestimoRepository.save(emprestimo);
        return emprestimo;
    }

    @PutMapping({"id"})
    public Emprestimo update(@PathVariable("id") Integer id, @RequestBody Emprestimo emprestimo){
        Optional<Emprestimo> emprestimoOptional = emprestimoRepository.findById(id);
        if(emprestimoOptional.isPresent()){
            Emprestimo emprestimoSalvo = emprestimoOptional.get();
            ClienteRepository clienteRepository;
            emprestimoSalvo.setCliente(emprestimo.getCliente());
            emprestimoSalvo.setData(emprestimo.getData());
            emprestimoSalvo.setExemplar(emprestimo.getExemplar());

            return emprestimoRepository.save(emprestimoSalvo);
        }else {
            throw new EntityNotFoundException("Empréstimo não encontrado");
        }
    }

    @DeleteMapping({"id"})
    public void delete(@PathVariable("id") Integer id){
        Optional<Emprestimo> emprestimoOptional = emprestimoRepository.findById(id);
        if(emprestimoOptional.isPresent()){
            emprestimoRepository.deleteById(id);
        }else {
            throw new EntityNotFoundException("Empréstimo não encontrado");
        }
    }
}
