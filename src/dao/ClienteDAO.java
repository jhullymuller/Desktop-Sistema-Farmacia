package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Cliente;


public class ClienteDAO   extends Dao implements DaoI<Cliente>{

	@Override
	public boolean cadastrar(Cliente cliente) {
		PreparedStatement ps = null;
		try {
			ps = conexao.prepareStatement("insert into cliente(nome, cpf, telefone,endereco) values (?, ?, ?,?)");
			ps.setString(1, cliente.getNome());
			ps.setString(2, cliente.getCpf());
			ps.setInt(3,cliente.getTelefone());
			ps.setString(4, cliente.getEndereco());
			int update = ps.executeUpdate();
			return update >= 1;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public boolean deletar(Cliente cliente) {
		PreparedStatement ps = null;
		try {
			ps = conexao.prepareStatement("delete from cliente where idcliente = ?");
			ps.setInt(1, cliente.getIdcliente());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}


	
	@Override
	public List<Cliente> listar(String nome) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Cliente> clientes = new ArrayList<Cliente>();
		try {
			ps = conexao.prepareStatement("select * from cliente where UPPER(nome) LIKE UPPER(?)");
			ps.setString(1, "%" + nome + "%");
			rs = ps.executeQuery();
			while (rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setIdcliente(rs.getInt("idcliente"));
				cliente.setNome(rs.getString("nome"));
				cliente.setCpf(rs.getString("cpf"));
				cliente.setTelefone(rs.getInt("telefone"));
				cliente.setEndereco(rs.getString("endereco"));
				clientes.add(cliente);
			}
			
			return clientes;
		} catch (SQLException e) {
			e.printStackTrace();
			return clientes;
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	
		
	}

	@Override
	public boolean alterar(Cliente cliente) {
		PreparedStatement ps = null;
		try { 
			ps = conexao.prepareStatement("update cliente set nome = ?, cpf = ?, telefone = ?, endereco = ? where  idcliente = ?");
			ps.setString(1, cliente.getNome());
			ps.setString(2, cliente.getCpf());
			ps.setInt(3, cliente.getTelefone());
			ps.setString(4, cliente.getEndereco());
			ps.setInt(5, cliente.getIdcliente());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	



	

		
	}

}
