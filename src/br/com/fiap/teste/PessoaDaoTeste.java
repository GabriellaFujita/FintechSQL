package br.com.fiap.teste;


import br.com.fiap.bean.Pessoa;
import br.com.fiap.dao.OraclePessoaDAO;

import java.time.LocalDate;

public class PessoaDaoTeste {
    public static void main(String[] args){
        //Instancia o DAO
        OraclePessoaDAO dao = new OraclePessoaDAO();

        //Instancia a Pessoa
       Pessoa pessoa= new Pessoa(1, "teste", "teste",LocalDate.now(),"email@teste");


        //Cadastra no banco de dados
        dao.cadastrar(pessoa);

        //Lista as Pessoas
        dao.listar();
        System.out.println(dao.listar());

        //atualizar a Pessoa
        dao.atualizar(pessoa);

        //Buscar por Id
        dao.buscarPorId(pessoa.getCodigo());

        System.out.println("Pessoa testado!");

    }
}
