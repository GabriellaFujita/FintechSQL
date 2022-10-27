package br.com.fiap.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import br.com.fiap.bean.Pessoa;
import br.com.fiap.jdbc.EmpresaDBManager;

public class OraclePessoaDAO implements PessoaDAO {

  private Connection conexao;

  @Override
  public void cadastrar(Pessoa pessoa) {
    PreparedStatement stmt = null;

    try {
      conexao = EmpresaDBManager.obterConexao();
      String sql = "INSERT INTO T_PESSOA(CD_PESSOA, NM_PESSOA, NM_CPF, DT_NASCIMENTO, DS_EMAIL) VALUES (SQ_PESSOA.NEXTVAL, ?, ?, ?, ?)";
      stmt = conexao.prepareStatement(sql);
      stmt.setString(1, pessoa.getNome());
      stmt.setString(2, pessoa.getCpf());
      java.sql.Date data = new java.sql.Date(pessoa.getDataNascimento().getDayOfYear());
      stmt.setDate(3, data);
      stmt.setString(4, pessoa.getEmail());
            
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
  public List<Pessoa> listar() {
    //Cria uma lista de pessoas
    List<Pessoa> lista = new ArrayList<Pessoa>();
    PreparedStatement stmt = null;
    ResultSet rs = null;
    try {
      conexao = EmpresaDBManager.obterConexao();
      stmt = conexao.prepareStatement("SELECT * FROM T_PESSOA");
      rs = stmt.executeQuery();

      //Percorre todos os registros encontrados
      while (rs.next()) {
        int codigo = rs.getInt("CD_PESSOA");
        String nome = rs.getString("NM_PESSOA");
        String cpf = rs.getString("NM_CPF");
        java.sql.Date data = rs.getDate("DT_NASCIMENTO");
        Calendar dataNascimento = Calendar.getInstance();
        dataNascimento.setTimeInMillis(data.getTime());
        String email = rs.getString("DS_EMAIL");
        
        //Cria um objeto Pessoa com as informações encontradas
        Pessoa pessoa = new Pessoa(codigo, nome, cpf, LocalDate.now(), email);
        //Adiciona a pessoa na lista
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

  @Override
  public void atualizar(Pessoa pessoa){
    PreparedStatement stmt = null;

    try {
      conexao = EmpresaDBManager.obterConexao();
      String sql = "UPDATE T_PESSOA SET NM_PESSOA = ?, NM_CPF = ?, DT_NASCIMENTO = ?, DS_EMAIL = ? WHERE CD_PESSOA = ?";
      stmt = conexao.prepareStatement(sql);
      stmt.setString(1, pessoa.getNome());
      stmt.setString(2, pessoa.getCpf());
      java.sql.Date data = new java.sql.Date(pessoa.getDataNascimento().getDayOfYear());
      stmt.setDate(3, data);
      stmt.setString(4, pessoa.getEmail());
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

  @Override
  public void remover(int codigo){
    PreparedStatement stmt = null;

    try {
      conexao = EmpresaDBManager.obterConexao();
      String sql = "DELETE FROM T_PESSOA WHERE CD_PESSOA = ?";
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
  public Pessoa buscarPorId(int codigoBusca){
    Pessoa pessoa = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    try {
      conexao = EmpresaDBManager.obterConexao();
      stmt = conexao.prepareStatement("SELECT * FROM T_PESSOA WHERE CD_PESSOA = ?");
      stmt.setInt(1, codigoBusca);
      rs = stmt.executeQuery();

      if (rs.next()){
        int codigo = rs.getInt("CD_PESSOA");
        String nome = rs.getString("NM_PESSOA");
        String cpf = rs.getString("NM_CPF");
        java.sql.Date data = rs.getDate("DT_NASCIMENTO");
        Calendar dataNascimento = Calendar.getInstance();
        dataNascimento.setTimeInMillis(data.getTime());
        String email = rs.getString("DS_EMAIL");
        
        pessoa = new Pessoa(codigo, nome, cpf,LocalDate.now(), email);
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
  