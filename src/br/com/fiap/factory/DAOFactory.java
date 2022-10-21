package br.com.fiap.factory;
  
  
	import br.com.fiap.dao.GastoDAO;
	import br.com.fiap.dao.InvestimentoDAO;
	import br.com.fiap.dao.MetaDAO;
	import br.com.fiap.dao.OracleGastoDAO;
	import br.com.fiap.dao.OracleInvestimentoDAO;
	import br.com.fiap.dao.OracleMetaDAO;
	import br.com.fiap.dao.OraclePessoaDAO;
	import br.com.fiap.dao.OracleReceitaDAO;
	import br.com.fiap.dao.OracleTransacaoDAO;
	import br.com.fiap.dao.PessoaDAO;
	import br.com.fiap.dao.ReceitaDAO;
	import br.com.fiap.dao.TransacaoDAO;
  
  public abstract class DAOFactory {
  
    public static GastoDAO getGastoDAO(){
      return new OracleGastoDAO();
    }
    
    public static InvestimentoDAO getInvestimentoDAO(){
        return new OracleInvestimentoDAO();
      }
      
    public static MetaDAO getMetaDAO(){
        return new OracleMetaDAO();
      }
      
    public static PessoaDAO getPessoaDAO(){
        return new OraclePessoaDAO();
      }
      
    public static ReceitaDAO getReceitaDAO(){
        return new OracleReceitaDAO();
      }
      
    public static TransacaoDAO getTransacaoDAO(){
        return new OracleTransacaoDAO();
      }
  }
      
