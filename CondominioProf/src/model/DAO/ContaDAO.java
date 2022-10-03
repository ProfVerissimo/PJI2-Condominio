package model.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.protocol.Resultset;

import java.sql.PreparedStatement;
import model.entity.Credenciais;
import util.TrataException;

//import com.mysql.cj.xdevapi.Statement;
import java.sql.Statement;

public class ContaDAO {
	public Credenciais getCredenciais(String email, String senha) throws TrataException {
		ConexaoDAO conexao = new ConexaoDAO();
		Connection conn;
		conn = conexao.getConexao();

		String sql = "SELECT * FROM conta WHERE email = '" + email + "'";
		Statement stmt = null;
		ResultSet resultSet = null;
		Credenciais credenciais = null;
		try {
			stmt = conn.createStatement();
			resultSet = stmt.executeQuery(sql);
			System.out.println("chamar sql");
			if (resultSet.next()) {
				String emailConta = resultSet.getString("email");
				String nomeConta = resultSet.getString("nome");
				String senhaConta = resultSet.getString("senha");
				if (senha.equals(senhaConta)) {
					credenciais = new Credenciais(emailConta, nomeConta, senhaConta);
					System.out.println("senha OK");
				} else {
					System.out.println("senha invalida");
				}
			}

		} catch (SQLException e) {
			throw new TrataException("Erro na execução do Selelct " + sql, e);

		}
		return credenciais;
	}

}
