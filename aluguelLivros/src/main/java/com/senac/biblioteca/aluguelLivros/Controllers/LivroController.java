package com.senac.biblioteca.aluguelLivros.Controllers;

import com.senac.biblioteca.aluguelLivros.Models.Livro;
import com.senac.biblioteca.aluguelLivros.Repository.LivroRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("acervo-livros")
public class LivroController {
    private final LivroRepository livroRepository;

    public LivroController(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }
    @GetMapping
    public Page<Livro> findAll(@RequestParam(name="numeroPagina", required = false, defaultValue = "0") int numeroPagina,
                               @RequestParam(name = "quantidade", required = false, defaultValue = "5") int quantidadeRegistro) {
        PageRequest pageRequest = PageRequest.of(numeroPagina,quantidadeRegistro);
        return livroRepository.findAll(pageRequest);
    }

    @GetMapping({"id"})
    public Livro findById(@PathVariable("id") Integer id){
        Optional<Livro> livroOptional = livroRepository.findById(id);

        if(livroOptional.isPresent()){
            return livroOptional.get();
        }else {
            throw new EntityNotFoundException("Título não encontrado");
        }
    }

    @PostMapping
    public Livro save(@RequestBody Livro livro){
        livroRepository.save(livro);
        return livro;
    }

    @PutMapping({"id"})
    public Livro update(@PathVariable("id") Integer id, @RequestBody Livro livro){
        Optional<Livro> livroOptional = livroRepository.findById(id);
        if(livroOptional.isPresent()){
            Livro livroSalvo = livroOptional.get();
            livroSalvo.setTitulo(livro.getTitulo());
            livroSalvo.setAnoPublicacao(livro.getAnoPublicacao());
            livroSalvo.setAutor(livro.getAutor());
            livroSalvo.setCategoria(livro.getCategoria());
            livroSalvo.setISBN(livro.getISBN());

            return livroRepository.save(livroSalvo);
        }else {
            throw new EntityNotFoundException("Título não encontrado");
        }
    }

    @DeleteMapping
    public void delete(@PathVariable("id") Integer id){
        Optional<Livro> livroOptional = livroRepository.findById(id);

        if (livroOptional.isPresent()){
            livroRepository.deleteById(id);
        }else {
            throw new EntityNotFoundException("Título não encontrado");
        }
    }

}
