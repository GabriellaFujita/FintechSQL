package br.com.fiap.dao;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import br.com.fiap.bean.Meta;
import br.com.fiap.jdbc.EmpresaDBManager;

public class OracleMetaDAO implements MetaDAO {

  private Connection conexao;

  @Override
  public void cadastrar(Meta meta) {
    PreparedStatement stmt = null;

    try {
      conexao = EmpresaDBManager.obterConexao();
      String sql = "INSERT INTO T_META(CD_META, CD_PESSOA, NM_META, DT_META_CRIACAO, DT_META_FINAL, VL_META) VALUES (SQ_META.NEXTVAL, ?, ?, ?, ?, ?)";
      stmt = conexao.prepareStatement(sql);
      stmt.setInt(1, meta.getCodigoPessoa());
      stmt.setString(2, meta.getNome());
      Date dataCriacao = new Date(meta.getDataCriacao().getDayOfYear());
      stmt.setDate(3, dataCriacao);
      Date dataFinal = new Date(meta.getDataFinal().getDayOfYear());
      stmt.setDate(4, dataFinal);
      stmt.setDouble(5, meta.getValor());
            
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
  public List<Meta> listar() {
    //Cria uma lista de metas
    List<Meta> lista = new ArrayList<Meta>();
    PreparedStatement stmt = null;
    ResultSet rs = null;
    try {
      conexao = EmpresaDBManager.obterConexao();
      stmt = conexao.prepareStatement("SELECT * FROM T_META");
      rs = stmt.executeQuery();

      //Percorre todos os registros encontrados
      while (rs.next()) {
        int codigo = rs.getInt("CD_META");
        int codigoPessoa = rs.getInt("CD_PESSOA");
        String nome = rs.getString("NM_META");
        java.sql.Date data1 = rs.getDate("DT_META_CRIACAO");
        Calendar dataCriacao = Calendar.getInstance();
        dataCriacao.setTimeInMillis(data1.getTime());
        java.sql.Date data2 = rs.getDate("DT_META_FINAL");
        Calendar dataFinal = Calendar.getInstance();
        dataFinal.setTimeInMillis(data2.getTime());
        double valor = rs.getDouble("VL_META");
        
        //Cria um objeto Meta com as informações encontradas
        Meta meta = new Meta(codigo, codigoPessoa, nome, LocalDate.now(), LocalDate.now(), valor);
        //Adiciona a meta na lista
        lista.add(meta);
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
  public void atualizar(Meta meta){
    PreparedStatement stmt = null;

    try {
      conexao = EmpresaDBManager.obterConexao();
      String sql = "UPDATE T_META SET CD_PESSOA = ?, NM_META = ?, DT_META_CRIACAO = ?, DT_META_FINAL = ?, VL_META = ? WHERE CD_META = ?";
      stmt = conexao.prepareStatement(sql);
      stmt.setInt(1, meta.getCodigoPessoa());
      stmt.setString(2, meta.getNome());
      Date dataCriacao = new Date(meta.getDataCriacao().getDayOfYear());
      stmt.setDate(3, dataCriacao);
      Date dataFinal = new Date(meta.getDataFinal().getDayOfYear());
      stmt.setDate(4, dataFinal);
      stmt.setDouble(5, meta.getValor());
      stmt.setInt(6, meta.getCodigo());

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
      String sql = "DELETE FROM T_META WHERE CD_META = ?";
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
  public Meta buscarPorId(int codigoBusca){
    Meta meta = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    try {
      conexao = EmpresaDBManager.obterConexao();
      stmt = conexao.prepareStatement("SELECT * FROM T_META WHERE CD_META = ?");
      stmt.setInt(1, codigoBusca);
      rs = stmt.executeQuery();

      if (rs.next()){
        int codigo = rs.getInt("CD_META");
        int codigoPessoa = rs.getInt("CD_PESSOA");
        String nome = rs.getString("NM_META");
        java.sql.Date data1 = rs.getDate("DT_META_CRIACAO");
        Calendar dataCriacao = Calendar.getInstance();
        dataCriacao.setTimeInMillis(data1.getTime());
        java.sql.Date data2 = rs.getDate("DT_META_FINAL");
        Calendar dataFinal = Calendar.getInstance();
        dataFinal.setTimeInMillis(data2.getTime());
        double valor = rs.getDouble("VL_META");
        
        meta = new Meta(codigo, codigoPessoa, nome, LocalDate.now(), LocalDate.now(), valor);
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
    return meta;
  }
}