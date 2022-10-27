package br.com.fiap.teste;

import br.com.fiap.bean.Investimento;
import br.com.fiap.dao.OracleInvestimentoDAO;

import java.time.LocalDate;


public class InvestimentoDaoTeste {
    public static void main(String[] args){
    //Instancia o DAO
    OracleInvestimentoDAO dao = new OracleInvestimentoDAO();

    //Instancia o investimento
    Investimento investimento = new Investimento(1,"teste",50, "tipo", 50, LocalDate.now());


    //Cadastra no banco de dados
    dao.cadastrar(investimento);

    //Lista os gastos
    dao.listar();
    System.out.println(dao.listar());

    //atualizar os gastos
    dao.atualizar(investimento);

    //Buscar por Id
     dao.buscarPorId(investimento.getCodigo());

        System.out.println("Investimento testado!");

}
}
