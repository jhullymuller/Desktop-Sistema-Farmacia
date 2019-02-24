package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Receita;


public class ReceitaDao   extends Dao implements DaoI<Receita>{

	@Override
	public boolean cadastrar(Receita receita) {
		PreparedStatement ps = null;
		try {
			ps = conexao.prepareStatement("insert into receita(tipo_receita, quantidade_caixa, cliente_idcliente,crs) values (?, ?, ?,?)");
			ps.setString(1, receita.getTipoReceita());
			ps.setInt(2, receita.getQuantidadeCaixa());
			ps.setInt(3, receita.getIdcliente());
			ps.setString(4, receita.getCrs());
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
	public boolean deletar(Receita receita) {
		PreparedStatement ps = null;
		try {
			ps = conexao.prepareStatement("delete from receita where idreceita = ?");
			ps.setInt(1, receita.getIdreceita());
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
	public List<Receita> listar(String nome) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Receita> receitas = new ArrayList<Receita>();
		try {
			ps = conexao.prepareStatement("select * from receita");
			rs = ps.executeQuery();
			while (rs.next()) {
				Receita receita = new Receita();
				receita.setIdreceita(rs.getInt("idreceita"));
				receita.setTipoReceita(rs.getString("tipo_receita"));
				receita.setQuantidadeCaixa(rs.getInt("quantidade_caixa"));
				receita.setIdcliente(rs.getInt("cliente_idcliente"));
				receita.setCrs(rs.getString("crs"));
				receitas.add(receita);
			}
			
			return receitas;
		} catch (SQLException e) {
			e.printStackTrace();
			return receitas;
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
	public boolean alterar(Receita receita) {
		PreparedStatement ps = null;
		try { 
			ps = conexao.prepareStatement("update receita set tipo_receita ?, quantidade_caixa = ?, cliente_idcliente = ?,crs = ? where  idreceita = ?");
			ps.setString(1, receita.getTipoReceita());
			ps.setInt(2, receita.getQuantidadeCaixa());
			ps.setInt(3, receita.getIdcliente());
			ps.setInt(4, receita.getIdreceita());
			ps.setString(5, receita.getCrs());
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
