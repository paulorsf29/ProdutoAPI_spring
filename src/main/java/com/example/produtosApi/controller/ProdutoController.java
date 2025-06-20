package com.example.produtosApi.controller;

import com.example.produtosApi.model.Produto;
import com.example.produtosApi.repository.ProdutoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("produto")
public class ProdutoController {

    private ProdutoRepository produtoRepository;

    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @PostMapping
    public Produto salvar(@RequestBody Produto produto){
        System.out.println("produto"+produto);
        var id = UUID.randomUUID().toString();
        produto.setId(id);

        produtoRepository.save(produto);
        return produto;
    }
    @GetMapping("/{id}")
    public  Produto obterPorId(@PathVariable("id") String id){
       return produtoRepository.findById(id).orElse(null);
    }
}
