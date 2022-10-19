package br.com.fiap.dao;
import java.util.List;
import br.com.fiap.bean.Investimento;

public interface InvestimentoDAO {
	
	    public void cadastrar(Investimento investimento);
	  
	    public List<Investimento> listar();
	    
	    public void atualizar(Investimento investimento);
	  
	    public void remover(int codigo);
	    
	    public Investimento buscarPorId(int codigoBusca);
	
}
