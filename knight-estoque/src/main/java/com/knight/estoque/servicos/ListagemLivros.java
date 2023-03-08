package com.knight.estoque.servicos;

import com.knight.estoque.daos.LivroDAO;
import com.knight.estoque.modelos.Livro;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import java.util.List;

@WebService
public class ListagemLivros {

    private LivroDAO dao = new LivroDAO();

    public List<Livro> listarLivros() {
        LivroDAO livroDAO = obterDAO();
        return livroDAO.listarLivros();
    }

    private LivroDAO obterDAO() {
        return this.dao;
    }

    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8080/livros", new ListagemLivros());
        System.out.println("Serviço inicializado!");
    }

}
