package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import model.Medicamento;

public class MedicamentoDAO extends Dao implements DaoI<Medicamento>{

	@Override
	public boolean cadastrar( Medicamento medicamento) {
		PreparedStatement ps = null;
		try {
			ps = conexao.prepareStatement("insert into medicamento (nome, valor, quantidade) values (?, ?, ?)");
			ps.setString(1, medicamento.getNome());
			ps.setDouble(2, medicamento.getValor());
			ps.setInt(3, medicamento.getQuantidade());
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
	public boolean deletar(Medicamento medicamento) {
		PreparedStatement ps = null;
		try {
			ps = conexao.prepareStatement("delete from medicamento where id = ?");
			ps.setInt(1, medicamento.getIdMedicamento());
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
	public  List<Medicamento> listar(String nome) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Medicamento> medicamentos = new ArrayList<Medicamento>();
		try {
			ps = conexao.prepareStatement("select * from medicamento where UPPER(nome) LIKE UPPER(?)");
			ps.setString(1, "%" + nome + "%");
			rs = ps.executeQuery();
			while (rs.next()) {
				Medicamento medicamento = new Medicamento();
				medicamento.setIdMedicamento(rs.getInt("id"));
				medicamento.setNome(rs.getString("nome"));
				medicamento.setValor(rs.getDouble("valor"));
				medicamento.setQuantidade(rs.getInt("quantidade"));
				medicamentos.add(medicamento);
			}
			
			return medicamentos;
		} catch (SQLException e) {
			e.printStackTrace();
			return medicamentos;
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
	public boolean alterar(Medicamento medicamento) {
		PreparedStatement ps = null;
		try {
			ps = conexao.prepareStatement("update medicamento set nome = ?, valor = ?, quantidade = ? where  id = ?");
			ps.setString(1, medicamento.getNome());
			ps.setDouble(2, medicamento.getValor());
			ps.setInt(3, medicamento.getQuantidade());
			ps.setInt(4, medicamento.getIdMedicamento());
			
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
	

