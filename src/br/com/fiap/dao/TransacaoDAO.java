package br.com.fiap.dao;
import java.util.List;
import br.com.fiap.bean.Transacao;

public interface TransacaoDAO {
	
	    public void cadastrar(Transacao transacao);
	  
	    public List<Transacao> listar();
	    
	    public void atualizar(Transacao transacao);
	  
	    public void remover(int codigo);
	    
	    public Transacao buscarPorId(int codigoBusca);
	
}