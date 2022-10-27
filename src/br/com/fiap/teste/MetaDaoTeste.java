package br.com.fiap.teste;


import br.com.fiap.bean.Meta;

import br.com.fiap.dao.OracleMetaDAO;

import java.time.LocalDate;

public class MetaDaoTeste {
    public static void main(String[] args){
        //Instancia o DAO
        OracleMetaDAO dao = new OracleMetaDAO();

        //Instancia a Meta
        Meta meta = new Meta(1, 1, "nome", LocalDate.now(), LocalDate.now(),0);


        //Cadastra no banco de dados
        dao.cadastrar(meta);

        //Lista as metas
        dao.listar();
        System.out.println(dao.listar());

        //atualizar as metas
        dao.atualizar(meta);

        //Buscar por Id
        dao.buscarPorId(meta.getCodigo());

        System.out.println("Meta testado!");

    }
}
