package br.com.fiap.dao;
import java.util.List;
import br.com.fiap.bean.Gasto;

public interface GastoDAO {
	
	    public void cadastrar(Gasto gasto);
	  
	    public List<Gasto> listar();
	    
	    public void atualizar(Gasto gasto);
	  
	    public void remover(int codigo);
	    
	    public Gasto buscarPorId(int codigoBusca);
	
}

