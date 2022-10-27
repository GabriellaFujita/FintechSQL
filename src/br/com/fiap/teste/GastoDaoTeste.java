package br.com.fiap.teste;

import br.com.fiap.bean.Gasto;
import br.com.fiap.dao.OracleGastoDAO;

public class GastoDaoTeste {

        public static void main(String[] args) {
            //Instancia o DAO
            OracleGastoDAO dao = new OracleGastoDAO();

            //Instancia o gasto
            Gasto gasto = new Gasto(1,"teste",50.0, "tipo teste");
            Gasto gastoAtualizado = new Gasto(1, "teste2",50,"tipo teste");

            //Cadastra no banco de dados
            dao.cadastrar(gasto);

            //Lista os gastos
            dao.listar();
            System.out.println(dao.listar());

            //atualizar os gastos
            dao.atualizar(gastoAtualizado);

            //Buscar por Id
            dao.buscarPorId(gasto.getCodigo());

            System.out.println("Gasto testado!");
        }

    }
