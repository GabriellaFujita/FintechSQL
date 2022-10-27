package br.com.fiap.teste;

import br.com.fiap.bean.Transacao;
import br.com.fiap.dao.FintechTransacaoDAO;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class TransacaoDaoTeste {
    public static void main(String[] args){
        //Instancia o DAO
        FintechTransacaoDAO dao = new FintechTransacaoDAO();

        //Instancia a Transação
        Transacao transacao= new Transacao(1, 50, LocalDate.now(), LocalDateTime.now(),1, 1,1, 1);


        //Cadastra no banco de dados
        dao.cadastrar(transacao);

        //Lista as transações
        dao.listar();
        System.out.println(dao.listar());

        //atualizar a transação
        dao.atualizar(transacao);

        //Buscar por Id
        dao.buscarPorId(transacao.getCodigo());

        System.out.println("Transação testado!");

    }
}
