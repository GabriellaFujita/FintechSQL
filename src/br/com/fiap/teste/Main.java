package br.com.fiap.teste;

import br.com.fiap.dao.*;
import br.com.fiap.bean.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {

    protected static void testarPessoa() {
        System.out.println("Testando Pessoa");
        OraclePessoaDAO dao = new OraclePessoaDAO();
        Pessoa pessoa = new Pessoa(1, "teste", "teste", LocalDate.now(), "email@teste");
        dao.cadastrar(pessoa);
        dao.listar();
        System.out.println(dao.listar());
        dao.atualizar(pessoa);
        dao.buscarPorId(pessoa.getCodigo());
        System.out.println("Pessoa testado!");
    }

    private static void testarMeta() {
        System.out.println("Testando Meta");
        OracleMetaDAO dao = new OracleMetaDAO();
        Meta meta = new Meta(1, 1, "nome", LocalDate.now(), LocalDate.now(), 0);
        dao.cadastrar(meta);
        dao.listar();
        System.out.println(dao.listar());
        dao.atualizar(meta);
        dao.buscarPorId(meta.getCodigo());
        System.out.println("Meta testado!");
    }

    private static void testarGasto() {
        System.out.println("Testando Gasto");
        OracleGastoDAO dao = new OracleGastoDAO();
        Gasto gasto = new Gasto(1, "teste", 50.0, "tipo teste");
        Gasto gastoAtualizado = new Gasto(1, "teste2", 50, "tipo teste");
        dao.cadastrar(gasto);
        dao.listar();
        System.out.println(dao.listar());
        dao.atualizar(gastoAtualizado);
        dao.buscarPorId(gasto.getCodigo());
        System.out.println("Gasto testado!");
    }

    private static void testarReceita() {
        System.out.println("Testando Receita");
        OracleReceitaDAO dao = new OracleReceitaDAO();
        Receita receita = new Receita(1, "teste", 50, "tipo teste");
        dao.cadastrar(receita);
        dao.listar();
        System.out.println(dao.listar());
        dao.atualizar(receita);
        dao.buscarPorId(receita.getCodigo());
        System.out.println("Receita testado!");
    }

    private static void testarInvestimento() {
        System.out.println("Testando Investimento");
        OracleInvestimentoDAO dao = new OracleInvestimentoDAO();
        Investimento investimento = new Investimento(1, "teste", 50, "tipo", 50, LocalDate.now());
        dao.cadastrar(investimento);
        dao.listar();
        System.out.println(dao.listar());
        dao.atualizar(investimento);
        dao.buscarPorId(investimento.getCodigo());
        System.out.println("Investimento testado!");
    }

    private static void testarTransacao() {
        System.out.println("Testando Transação");
        OracleTransacaoDAO dao = new OracleTransacaoDAO();
        Transacao transacao = new Transacao(1, 50, LocalDateTime.now(), 1, 1, 1, 1);
        dao.cadastrar(transacao);
        dao.listar();
        System.out.println(dao.listar());
        dao.atualizar(transacao);
        dao.buscarPorId(transacao.getCodigo());
        System.out.println("Transação testado!");

    }

    public static void main(String[] args) {
        System.out.println("Começando testes");
        testarPessoa();
        testarMeta();
        testarGasto();
        testarReceita();
        testarInvestimento();
        testarTransacao();
        System.out.println("Testes concluidos");
    }

}
