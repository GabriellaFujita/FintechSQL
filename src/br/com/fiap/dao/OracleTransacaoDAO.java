package br.com.fiap.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Clock;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import br.com.fiap.bean.Transacao;
import br.com.fiap.jdbc.EmpresaDBManager;

public class OracleTransacaoDAO implements TransacaoDAO {

  private Connection conexao;

  @Override
  public void cadastrar(Transacao transacao) {
    PreparedStatement stmt = null;

    try {
      conexao = EmpresaDBManager.obterConexao();
      String sql = "INSERT INTO T_TRANSACAO(CD_TRANSACAO, VL_TRANSACAO, DT_TRANSACAO, CD_GASTO, CD_RECEITA, CD_INVESTIMENTO, CD_PESSOA) VALUES (SQ_TRANSACAO.NEXTVAL, ?, ?, ?, ?, ?, ?)";
      stmt = conexao.prepareStatement(sql);
      stmt.setDouble(1, transacao.getValor());
      java.sql.Date data = new java.sql.Date(transacao.getDataTransacao().getDayOfYear());
      stmt.setDate(2, data);
      stmt.setInt(3, transacao.getCodigoGasto());
      stmt.setInt(4, transacao.getCodigoReceita());
      stmt.setInt(5, transacao.getCodigoInvestimento());
      stmt.setInt(6, transacao.getCodigoPessoa());
            
      stmt.executeUpdate();
    } catch (SQLException e) {
    	e.printStackTrace();
    } finally {
      try {
        stmt.close();
        conexao.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  } 

  @Override
  public List<Transacao> listar() {
    //Cria uma lista de transa��es
    List<Transacao> lista = new ArrayList<Transacao>();
    PreparedStatement stmt = null;
    ResultSet rs = null;
    try {
      conexao = EmpresaDBManager.obterConexao();
      stmt = conexao.prepareStatement("SELECT * FROM T_TRANSACAO");
      rs = stmt.executeQuery();

      //Percorre todos os registros encontrados
      while (rs.next()) {
        int codigo = rs.getInt("CD_TRANSACAO");
        double valor = rs.getDouble("VL_TRANSACAO");
        java.sql.Date data = rs.getDate("DT_TRANSACAO");
        Calendar dataTransacao = Calendar.getInstance();
        dataTransacao.setTimeInMillis(data.getTime());
        int codigoGasto = rs.getInt("CD_GASTO");
        int codigoReceita = rs.getInt("CD_RECEITA");
        int codigoInvestimento = rs.getInt("CD_INVESTIMENTO");
        int codigoPessoa = rs.getInt("CD_PESSOA");
       
        //Cria um objeto Transacao com as informa��es encontradas
        Transacao transacao = new Transacao(codigo, valor, LocalDateTime.now(Clock.systemDefaultZone()), codigoGasto, codigoReceita, codigoInvestimento, codigoPessoa);
        //Adiciona a transa��o na lista
        lista.add(transacao);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      try {
        stmt.close();
        rs.close();
        conexao.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    return lista;
  }

  @Override
  public void atualizar(Transacao transacao){
    PreparedStatement stmt = null;

    try {
      conexao = EmpresaDBManager.obterConexao();
      String sql = "UPDATE T_TRANSACAO SET VL_TRANSACAO = ?, DT_TRANSACAO = ?, CD_GASTO = ?, CD_RECEITA = ?, CD_INVESTIMENTO = ?, CD_PESSOA = ? WHERE CD_TRANSACAO = ?";
      stmt = conexao.prepareStatement(sql);
      stmt.setDouble(1, transacao.getValor());
      java.sql.Date data = new java.sql.Date(transacao.getDataTransacao().getDayOfYear());
      stmt.setDate(2, data);
      stmt.setInt(3, transacao.getCodigoGasto());
      stmt.setInt(4, transacao.getCodigoReceita());
      stmt.setInt(5, transacao.getCodigoInvestimento());
      stmt.setInt(6, transacao.getCodigoPessoa());
      stmt.setInt(7, transacao.getCodigo());
      
      stmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      try {
        stmt.close();
        conexao.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }

  @Override
  public void remover(int codigo){
    PreparedStatement stmt = null;

    try {
      conexao = EmpresaDBManager.obterConexao();
      String sql = "DELETE FROM T_TRANSACAO WHERE CD_TRANSACAO = ?";
      stmt = conexao.prepareStatement(sql);
      stmt.setInt(1, codigo);
      stmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      try {
        stmt.close();
        conexao.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }

  @Override
  public Transacao buscarPorId(int codigoBusca){
    Transacao transacao = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    try {
      conexao = EmpresaDBManager.obterConexao();
      stmt = conexao.prepareStatement("SELECT * FROM T_TRANSACAO WHERE CD_TRANSACAO = ?");
      stmt.setInt(1, codigoBusca);
      rs = stmt.executeQuery();

      if (rs.next()){
		  int codigo = rs.getInt("CD_TRANSACAO");
	      double valor = rs.getDouble("VL_TRANSACAO");
	      java.sql.Date data = rs.getDate("DT_TRANSACAO");
	      Calendar dataTransacao = Calendar.getInstance();
	      dataTransacao.setTimeInMillis(data.getTime());
	      int codigoGasto = rs.getInt("CD_GASTO");
	      int codigoReceita = rs.getInt("CD_RECEITA");
	      int codigoInvestimento = rs.getInt("CD_INVESTIMENTO");
	      int codigoPessoa = rs.getInt("CD_PESSOA");
	      	
	      transacao = new Transacao(codigo, valor,LocalDateTime.now(), codigoGasto, codigoReceita, codigoInvestimento, codigoPessoa);
      }
      
    } catch (SQLException e) {
      e.printStackTrace();
    }finally {
      try {
        stmt.close();
        rs.close();
        conexao.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    return transacao;
  }
}