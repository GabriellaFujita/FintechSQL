package br.com.fiap.dao;
import java.util.List;
import br.com.fiap.bean.Meta;

public interface MetaDAO {
	
	    public void cadastrar(Meta meta);
	  
	    public List<Meta> listar();
	    
	    public void atualizar(Meta meta);
	  
	    public void remover(int codigo);
	    
	    public Meta buscarPorId(int codigoBusca);
	
}