package br.com.fiap.dao;
import java.util.List;
import br.com.fiap.bean.Receita;

public interface ReceitaDAO {
	
	    public void cadastrar(Receita receita);
	  
	    public List<Receita> listar();
	    
	    public void atualizar(Receita receita);
	  
	    public void remover(int codigo);
	    
	    public Receita buscarPorId(int codigoBusca);
	
}