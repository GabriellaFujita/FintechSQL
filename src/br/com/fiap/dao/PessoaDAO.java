package br.com.fiap.dao;
import java.util.List;
import br.com.fiap.bean.Pessoa;

public interface PessoaDAO {
	
	    public void cadastrar(Pessoa pessoa);
	  
	    public List<Pessoa> listar();
	    
	    public void atualizar(Pessoa pessoa);
	  
	    public void remover(int codigo);
	    
	    public Pessoa buscarPorId(int codigoBusca);
	
}
