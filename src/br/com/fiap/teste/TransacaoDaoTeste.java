package br.com.fiap.teste;

import br.com.fiap.bean.Transacao;
import br.com.fiap.dao.OracleTransacaoDAO;

import java.util.Calendar;

public class TransacaoDaoTeste {
    public static void main(String[] args){
        //Instancia o DAO
        OracleTransacaoDAO dao = new OracleTransacaoDAO();

        //Instancia a Transa��o
        Transacao transacao= new Transacao(1, 50, Calendar.getInstance(), 1, 1, 1, 1);


        //Cadastra no banco de dados
        dao.cadastrar(transacao);

        //Lista as transa��es
        dao.listar();
        System.out.println(dao.listar());

        //atualizar a transa��o
        dao.atualizar(transacao);

        //Buscar por Id
        dao.buscarPorId(transacao.getCodigo());

        System.out.println("Transa��o testado!");

    }
}