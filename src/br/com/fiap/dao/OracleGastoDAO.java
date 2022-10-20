package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.bean.Gasto;

public class OracleGastoDAO implements GastoDAO {
	  
    public List<Gasto> listar(){
		return null;    
    }
    
    public void cadastrar(Gasto gasto){
    }

	@Override
	public void atualizar(Gasto gasto) {
		
	}

	@Override
	public void remover(int codigo) {
		
	}

	@Override
	public Gasto buscarPorId(int codigoBusca) {
		return null;
	}
  }