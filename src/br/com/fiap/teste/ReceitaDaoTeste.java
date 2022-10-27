package br.com.fiap.teste;

import br.com.fiap.bean.Receita;
import br.com.fiap.dao.OracleReceitaDAO;

public class ReceitaDaoTeste {
    public static void main(String[] args){
        //Instancia o DAO
        OracleReceitaDAO dao = new OracleReceitaDAO();

        //Instancia o investimento
        Receita receita = new Receita(1, "teste", 50, "tipo teste");


        //Cadastra no banco de dados
        dao.cadastrar(receita);

        //Lista os gastos
        dao.listar();
        System.out.println(dao.listar());

        //atualizar os gastos
        dao.atualizar(receita);

        //Buscar por Id
        dao.buscarPorId(receita.getCodigo());

        System.out.println("Receita testado!");

    }
}