package br.com.fiap.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import br.com.fiap.bean.Gasto;
import br.com.fiap.jdbc.EmpresaDBManager;

public class FintechGastoDAO implements GastoDAO {

  private Connection conexao;

  public void cadastrar(Gasto gasto) {
    PreparedStatement stmt = null;

    try {
      conexao = EmpresaDBManager.obterConexao();
      String sql = "INSERT INTO T_GASTO(CD_GASTO, NM_GASTO, VL_GASTO, DS_TIPO) VALUES (SQ_GASTO.NEXTVAL, ?, ?, ?)";
      stmt = conexao.prepareStatement(sql);
      stmt.setString(1, gasto.getNome());
      stmt.setDouble(2, gasto.getValor());
      stmt.setString(3, gasto.getTipo());
          
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

  public List<Gasto> listar() {
    //Cria uma lista de gastos
    List<Gasto> lista = new ArrayList<Gasto>();
    PreparedStatement stmt = null;
    ResultSet rs = null;
    try {
      conexao = EmpresaDBManager.obterConexao();
      stmt = conexao.prepareStatement("SELECT * FROM T_GASTO");
      rs = stmt.executeQuery();

      //Percorre todos os registros encontrados
      while (rs.next()) {
        int codigo = rs.getInt("CD_GASTO");
        String nome = rs.getString("NM_GASTO");
        double valor = rs.getDouble("VL_GASTO");
        String tipo = rs.getString("DS_TIPO");
        
        //Cria um objeto Gasto com as informações encontradas
        Gasto gasto = new Gasto(codigo, nome, valor, tipo);
        //Adiciona a meta na lista
        lista.add(gasto);
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

  public void atualizar(Gasto gasto){
    PreparedStatement stmt = null;

    try {
      conexao = EmpresaDBManager.obterConexao();
      String sql = "UPDATE T_GASTO SET NM_GASTO = ?, VL_GASTO = ?, DS_TIPO = ? WHERE CD_GASTO = ?";
      stmt = conexao.prepareStatement(sql);
      stmt.setString(1, gasto.getNome());
      stmt.setDouble(2, gasto.getValor());
      stmt.setString(3, gasto.getTipo());
      stmt.setInt(4, gasto.getCodigo());

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
      String sql = "DELETE FROM T_GASTO WHERE CD_GASTO = ?";
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

  public Gasto buscarPorId(int codigoBusca){
    Gasto gasto = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    try {
      conexao = EmpresaDBManager.obterConexao();
      stmt = conexao.prepareStatement("SELECT * FROM T_GASTO WHERE CD_GASTO = ?");
      stmt.setInt(1, codigoBusca);
      rs = stmt.executeQuery();

      if (rs.next()){
        int codigo = rs.getInt("CD_GASTO");
        String nome = rs.getString("NM_GASTO");
        double valor = rs.getDouble("VL_GASTO");
        String tipo = rs.getString("DS_TIPO");
        
        gasto = new Gasto(codigo, nome, valor, tipo);
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
    return gasto;
  }
}