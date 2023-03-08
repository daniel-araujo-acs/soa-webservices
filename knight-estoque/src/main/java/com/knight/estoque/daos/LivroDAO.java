package com.knight.estoque.daos;

import com.knight.estoque.modelos.Livro;

import java.util.ArrayList;
import java.util.List;

public class LivroDAO {

    private final List<Livro> livros = new ArrayList<>();

    public LivroDAO() {
        Livro logica = new Livro();
        logica.setAnoDePublicacao(2012);
        logica.getAutores().add("Paulo Silveira");
        logica.getAutores().add("Adriano Almeida");
        logica.setEditora("Casa do Código");
        logica.setNome("Guia do Programador");
        logica.setResumo("Vá do \"nunca programei\" ...");

        Livro rails = new Livro();
        rails.setAnoDePublicacao(2012);
        rails.getAutores().add("Vinícius Baggio Fuentes");
        rails.setEditora("Casa do Código");
        rails.setNome("Ruby on Rails");
        rails.setResumo("Crie rapidamente aplicações web");

        this.livros.add(logica);
        this.livros.add(rails);
    }

    public List<Livro> listarLivros() {
        return this.livros;
    }

}
