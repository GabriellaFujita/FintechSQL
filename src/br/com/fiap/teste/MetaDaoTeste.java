package br.com.fiap.teste;


import br.com.fiap.bean.Meta;

import br.com.fiap.dao.FintechMetaDAO;

import java.time.LocalDate;

public class MetaDAOTeste {
    public static void main(String[] args){
        //Instancia o DAO
        FintechMetaDAO dao = new FintechMetaDAO();

        //Instancia o investimento
        Meta meta = new Meta(1, 1, "nome", LocalDate.now(), LocalDate.now(), LocalDate.now(),0);


        //Cadastra no banco de dados
        dao.cadastrar(meta);

        //Lista os gastos
        dao.listar();
        System.out.println(dao.listar());

        //atualizar os gastos
        dao.atualizar(meta);

        //Buscar por Id
        dao.buscarPorId(meta.getCodigo());

        System.out.println("Meta testado!");

    }
}
