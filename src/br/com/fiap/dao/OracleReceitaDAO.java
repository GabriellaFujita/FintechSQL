package br.com.fiap.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.fiap.bean.Receita;
import br.com.fiap.jdbc.EmpresaDBManager;

public class OracleReceitaDAO implements ReceitaDAO {

  private Connection conexao;

  @Override
  public void cadastrar(Receita receita) {
    PreparedStatement stmt = null;

    try {
      conexao = EmpresaDBManager.obterConexao();
      String sql = "INSERT INTO T_RECEITA(CD_RECEITA, NM_RECEITA, VL_RECEITA, DS_TIPO) VALUES (SQ_RECEITA.NEXTVAL, ?, ?, ?)";
      stmt = conexao.prepareStatement(sql);
      stmt.setString(1, receita.getNome());
      stmt.setDouble(2, receita.getValor());
      stmt.setString(3, receita.getTipo());
          
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
  public List<Receita> listar() {
    //Cria uma lista de receitas
    List<Receita> lista = new ArrayList<Receita>();
    PreparedStatement stmt = null;
    ResultSet rs = null;
    try {
      conexao = EmpresaDBManager.obterConexao();
      stmt = conexao.prepareStatement("SELECT * FROM T_RECEITA");
      rs = stmt.executeQuery();

      //Percorre todos os registros encontrados
      while (rs.next()) {
        int codigo = rs.getInt("CD_RECEITA");
        String nome = rs.getString("NM_RECEITA");
        double valor = rs.getDouble("VL_RECEITA");
        String tipo = rs.getString("DS_TIPO");
        
        //Cria um objeto Receita com as informações encontradas
        Receita receita = new Receita(codigo, nome, valor, tipo);
        //Adiciona a meta na lista
        lista.add(receita);
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
  public void atualizar(Receita receita){
    PreparedStatement stmt = null;

    try {
      conexao = EmpresaDBManager.obterConexao();
      String sql = "UPDATE T_RECEITA SET NM_RECEITA = ?, VL_RECEITA = ?, DS_TIPO = ? WHERE CD_RECEITA = ?";
      stmt = conexao.prepareStatement(sql);
      stmt.setString(1, receita.getNome());
      stmt.setDouble(2, receita.getValor());
      stmt.setString(3, receita.getTipo());
      stmt.setInt(4, receita.getCodigo());

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
      String sql = "DELETE FROM T_RECEITA WHERE CD_RECEITA = ?";
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
  public Receita buscarPorId(int codigoBusca){
    Receita receita = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    try {
      conexao = EmpresaDBManager.obterConexao();
      stmt = conexao.prepareStatement("SELECT * FROM T_RECEITA WHERE CD_RECEITA = ?");
      stmt.setInt(1, codigoBusca);
      rs = stmt.executeQuery();

      if (rs.next()){
        int codigo = rs.getInt("CD_RECEITA");
        String nome = rs.getString("NM_RECEITA");
        double valor = rs.getDouble("VL_RECEITA");
        String tipo = rs.getString("DS_TIPO");
        
        receita = new Receita(codigo, nome, valor, tipo);
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
    return receita;
  }
}
