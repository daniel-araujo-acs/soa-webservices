package com.knight.estoque.servicos;

import java.util.List;

public class Client {

    public static void main(String[] args) {
        ListagemLivrosService listagemLivrosFactory = new ListagemLivrosService();
        ListagemLivros listagemLivros = listagemLivrosFactory.getListagemLivrosPort();
        List<Livro> livros = listagemLivros.listarLivros();

        for (Livro livro : livros) {
            System.out.println("Nome: " + livro.getNome());
        }
    }

}
