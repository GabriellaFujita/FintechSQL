package br.com.fiap.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import br.com.fiap.bean.Investimento;
import br.com.fiap.jdbc.EmpresaDBManager;

public class FintechInvestimentoDAO implements InvestimentoDAO {

  private Connection conexao;

  public void cadastrar(Investimento investimento) {
    PreparedStatement stmt = null;

    try {
      conexao = EmpresaDBManager.obterConexao();
      String sql = "INSERT INTO T_INVESTIMENTO(CD_INVESTIMENTO, NM_INVESTIMENTO, VL_INVESTIMENTO, DS_TIPO, VL_RENDIMENTO, DT_DISPONIVEL) VALUES (SQ_INVESTIMENTO.NEXTVAL, ?, ?, ?, ?, ?)";
      stmt = conexao.prepareStatement(sql);
      stmt.setString(1, investimento.getNome());
      stmt.setDouble(2, investimento.getValor());
      stmt.setString(3, investimento.getTipo());
      stmt.setDouble(4, investimento.getValorRendimento());
      java.sql.Date dataDisponivel = new java.sql.Date(investimento.getDataDisponivel().getTimeInMillis());
      stmt.setDate(5, dataDisponivel);    
            
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

  public List<Investimento> listar() {
    //Cria uma lista de investimentos
    List<Investimento> lista = new ArrayList<Investimento>();
    PreparedStatement stmt = null;
    ResultSet rs = null;
    try {
      conexao = EmpresaDBManager.obterConexao();
      stmt = conexao.prepareStatement("SELECT * FROM T_INVESTIMENTO");
      rs = stmt.executeQuery();

      //Percorre todos os registros encontrados
      while (rs.next()) {
        int codigo = rs.getInt("CD_INVESTIMENTO");
        String nome = rs.getString("NM_INVESTIMENTO");
        double valor = rs.getDouble("VL_INVESTIMENTO");
        String tipo = rs.getString("DS_TIPO");
        double valorRendimento = rs.getDouble("VL_RENDIMENTO");
        java.sql.Date data = rs.getDate("DT_DISPONIVEL");
        Calendar dataDisponivel = Calendar.getInstance();
        dataDisponivel.setTimeInMillis(data.getTime());
        
        //Cria um objeto Investimento com as informações encontradas
        Investimento investimento = new Investimento(codigo, nome, valor, tipo, valorRendimento, dataDisponivel);
        //Adiciona a meta na lista
        lista.add(investimento);
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

  public void atualizar(Investimento investimento){
    PreparedStatement stmt = null;

    try {
      conexao = EmpresaDBManager.obterConexao();
      String sql = "UPDATE T_INVESTIMENTO SET NM_INVESTIMENTO = ?, VL_INVESTIMENTO = ?, DS_TIPO = ?, VL_RENDIMENTO = ?, DT_DISPONIVEL = ? WHERE CD_INVESTIMENTO = ?";
      stmt = conexao.prepareStatement(sql);
      stmt.setString(1, investimento.getNome());
      stmt.setDouble(2, investimento.getValor());
      stmt.setString(3, investimento.getTipo());
      stmt.setDouble(4, investimento.getValorRendimento());
      java.sql.Date dataDisponivel = new java.sql.Date(investimento.getDataDisponivel().getTimeInMillis());
      stmt.setDate(5, dataDisponivel);
      stmt.setInt(6, investimento.getCodigo());

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

  public void remover(int codigo){
    PreparedStatement stmt = null;

    try {
      conexao = EmpresaDBManager.obterConexao();
      String sql = "DELETE FROM T_INVESTIMENTO WHERE CD_INVESTIMENTO = ?";
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

  public Investimento buscarPorId(int codigoBusca){
    Investimento investimento = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    try {
      conexao = EmpresaDBManager.obterConexao();
      stmt = conexao.prepareStatement("SELECT * FROM T_INVESTIMENTO WHERE CD_INVESTIMENTO = ?");
      stmt.setInt(1, codigoBusca);
      rs = stmt.executeQuery();

      if (rs.next()){
        int codigo = rs.getInt("CD_INVESTIMENTO");
        String nome = rs.getString("NM_INVESTIMENTO");
        double valor = rs.getDouble("VL_INVESTIMENTO");
        String tipo = rs.getString("DS_TIPO");
        double valorRendimento = rs.getDouble("VL_RENDIMENTO");
        java.sql.Date data = rs.getDate("DT_DISPONIVEL");
        Calendar dataDisponivel = Calendar.getInstance();
        dataDisponivel.setTimeInMillis(data.getTime());
        
        investimento = new Investimento(codigo, nome, valor, tipo, valorRendimento, dataDisponivel);
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
    return investimento;
  }
}