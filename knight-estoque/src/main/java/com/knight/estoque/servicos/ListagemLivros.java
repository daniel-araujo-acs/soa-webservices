package com.knight.estoque.servicos;

import com.knight.estoque.daos.LivroDAO;
import com.knight.estoque.modelos.Livro;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;
import java.util.List;

@WebService
public class ListagemLivros {

    private final LivroDAO dao = new LivroDAO();

    @WebResult(name = "livro")
    public List<Livro> listarLivros() {
        LivroDAO livroDAO = obterDAO();
        return livroDAO.listarLivros();
    }

    @RequestWrapper(className = "com.knight.estoque.servicos.jaxws.ListarLivrosPaginacao", localName = "listarLivrosPaginacao")
    @ResponseWrapper(className = "com.knight.estoque.servicos.jaxws.ListarLivrosPaginacaoResponse", localName = "listarLivrosPaginacaoResponse")
    @WebResult(name = "livro")
    @WebMethod(operationName = "listarLivrosPaginacao")
    public List<Livro> listarLivros(Integer numeroDaPagina, Integer tamanhoDaPagina) {
        LivroDAO livroDAO = obterDAO();
        return livroDAO.listarLivros(numeroDaPagina, tamanhoDaPagina);
    }

    private LivroDAO obterDAO() {
        return this.dao;
    }

    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8080/livros", new ListagemLivros());
        System.out.println("Serviço inicializado!");
    }

}
