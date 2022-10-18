package br.com.fiap.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import br.com.fiap.bean.Pessoa;
import br.com.fiap.jdbc.EmpresaDBManager;

public class FintechPessoaDAO implements PessoaDAO {

  private Connection conexao;

  public void cadastrar(Pessoa pessoa) {
    PreparedStatement stmt = null;

    try {
      conexao = EmpresaDBManager.obterConexao();
      String sql = "INSERT INTO TAB_COLABORADOR(CODIGO_COLABORADOR, NOME, EMAIL, SALARIO, DATA_CONTRATACAO) VALUES (SQ_COLABORADOR.NEXTVAL, ?, ?, ?, ?)";
      stmt = conexao.prepareStatement(sql);
      stmt.setString(1, pessoa.getNome());
      stmt.setString(2, pessoa.getEmail());
      stmt.setDouble(3, pessoa.getSalario());
      java.sql.Date data = new java.sql.Date(pessoa.getDataContratacao().getTimeInMillis());
      stmt.setDate(4, data);
      
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

  public List<Pessoa> listar() {
    //Cria uma lista de colaboradores
    List<Pessoa> lista = new ArrayList<Pessoa>();
    PreparedStatement stmt = null;
    ResultSet rs = null;
    try {
      conexao = EmpresaDBManager.obterConexao();
      stmt = conexao.prepareStatement("SELECT * FROM TAB_COLABORADOR");
      rs = stmt.executeQuery();

      //Percorre todos os registros encontrados
      while (rs.next()) {
        int codigo = rs.getInt("CODIGO_COLABORADOR");
        String nome = rs.getString("NOME");
        String email = rs.getString("EMAIL");
        double salario = rs.getDouble("SALARIO");
        java.sql.Date data = rs.getDate("DATA_CONTRATACAO");
        Calendar dataContratacao = Calendar.getInstance();
        dataContratacao.setTimeInMillis(data.getTime());
        //Cria um objeto Colaborador com as informações encontradas
        Pessoa pessoa = new Pessoa(codigo, nome, email, salario, dataContratacao);
        //Adiciona o colaborador na lista
        lista.add(pessoa);
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

  public void atualizar(Pessoa pessoa){
    PreparedStatement stmt = null;

    try {
      conexao = EmpresaDBManager.obterConexao();
      String sql = "UPDATE TAB_COLABORADOR SET NOME = ?, EMAIL = ?, SALARIO = ?, DATA_CONTRATACAO = ? WHERE CODIGO_COLABORADOR = ?";
      stmt = conexao.prepareStatement(sql);
      stmt.setString(1, pessoa.getNome());
      stmt.setString(2, pessoa.getEmail());
      stmt.setDouble(3, pessoa.getSalario());
      java.sql.Date data = new java.sql.Date(pessoa.getDataContratacao().getTimeInMillis());
      stmt.setDate(4, data);
      stmt.setInt(5, pessoa.getCodigo());

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
      String sql = "DELETE FROM TAB_COLABORADOR WHERE CODIGO_COLABORADOR = ?";
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

  public Pessoa buscarPorId(int codigoBusca){
    Pessoa pessoa = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    try {
      conexao = EmpresaDBManager.obterConexao();
      stmt = conexao.prepareStatement("SELECT * FROM TAB_COLABORADOR WHERE CODIGO_COLABORADOR = ?");
      stmt.setInt(1, codigoBusca);
      rs = stmt.executeQuery();

      if (rs.next()){
        int codigo = rs.getInt("CODIGO_COLABORADOR");
        String nome = rs.getString("NOME");
        String email = rs.getString("EMAIL");
        double salario = rs.getDouble("SALARIO");
        java.sql.Date data = rs.getDate("DATA_CONTRATACAO");
        Calendar dataContratacao = Calendar.getInstance();
        dataContratacao.setTimeInMillis(data.getTime());
        pessoa = new Pessoa(codigo, nome, email, salario, dataContratacao);
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
    return pessoa;
  }
}
  