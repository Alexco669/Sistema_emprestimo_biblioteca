package com.senac.biblioteca.aluguelLivros.Controllers;

import com.senac.biblioteca.aluguelLivros.Models.Exemplar;
import com.senac.biblioteca.aluguelLivros.Models.Livro;
import com.senac.biblioteca.aluguelLivros.Repository.ExemplarRepository;
import com.senac.biblioteca.aluguelLivros.Repository.LivroRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("estoque_exemplares")
public class ExemplarController {

    private final ExemplarRepository exemplarRepository;

    public ExemplarController(ExemplarRepository exemplarRepository) {
        this.exemplarRepository = exemplarRepository;
    }

    @GetMapping
    public Page<Exemplar> findAll(@RequestParam(name="numeroPagina", required = false, defaultValue = "0") int numeroPagina,
                                  @RequestParam(name = "quantidade", required = false, defaultValue = "5") int quantidadeRegistro) {
        PageRequest pageRequest = PageRequest.of(numeroPagina,quantidadeRegistro);
        return exemplarRepository.findAll(pageRequest);
    }

    @GetMapping({"id"})
    public Exemplar findById(@PathVariable("id") Integer id){
        Optional<Exemplar> exemplarOptional = exemplarRepository.findById(id);

        if(exemplarOptional.isPresent()){
            return exemplarOptional.get();
        }else {
            throw new EntityNotFoundException("Exemplar não encontrado");
        }
    }

    @PostMapping
    public Exemplar save(@RequestBody Exemplar exemplar){
        exemplarRepository.save(exemplar);
        return exemplar;
    }

    @PutMapping({"id"})
    public Exemplar update(@PathVariable("id") Integer id, @RequestBody Exemplar exemplar){
        Optional<Exemplar> exemplarOptional = exemplarRepository.findById(id);
        if(exemplarOptional.isPresent()){
            Exemplar exemplarSalvo = exemplarOptional.get();
            exemplarSalvo.setLivro(exemplar.getLivro());
            exemplarSalvo.setReferencia(exemplar.getReferencia());
            exemplarSalvo.setDisponivel(exemplar.isDisponivel());

            return exemplarRepository.save(exemplarSalvo);
        }else {
            throw new EntityNotFoundException("Exemplar não encontrado");
        }
    }

    @DeleteMapping({"id"})
    public void delete(@PathVariable("id") Integer id){
        Optional<Exemplar> exemplarOptional = exemplarRepository.findById(id);
        if(exemplarOptional.isPresent()){
            exemplarRepository.deleteById(id);
        }else {
            throw new EntityNotFoundException("Exemplar não encontrado");
        }
    }

}
