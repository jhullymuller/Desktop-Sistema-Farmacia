package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import model.Venda;
import model.VendaMedicamento;

public class VendaDao extends Dao {

	public boolean cadastrar(Venda venda) {
		PreparedStatement ps = null;
		try {
			ps = conexao.prepareStatement("insert into venda (valortotal,cliente_idcliente,data,formaPagamento) values (?,?,?,?)");
			ps.setDouble(1, venda.getValorTotal());
			ps.setInt(2, venda.getIdcliente());
			ps.setDate(3, new Date(venda.getData().getTime()));
			ps.setString(4,venda.getFormaPagamento());
			int idVenda = ps.executeUpdate();
			
			List<VendaMedicamento> listaMedicamentos = venda.getListaMedicamentos();
			for (int i = 0; i < listaMedicamentos.size(); i++) {
				VendaMedicamento vendaMedicamento = listaMedicamentos.get(i);
				vendaMedicamento.setIdVenda(idVenda);
				cadastrarVendaMedicamento(vendaMedicamento);
			}
			
			return idVenda >= 1;
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
	
	public boolean cadastrarVendaMedicamento(VendaMedicamento vendaMedicamento) {
		PreparedStatement ps = null;
		try {
			ps = conexao.prepareStatement("insert into venda_medicamento (quantidade,idmedicamento,idvenda,valor,receita_idreceita) values (?,?,?,?,?)");
			ps.setInt(1, vendaMedicamento.getQuantidade());
			ps.setInt(2, vendaMedicamento.getMedicamento().getIdMedicamento());
			ps.setInt(3, vendaMedicamento.getIdVenda());
			ps.setDouble(4, vendaMedicamento.getValor());
			ps.setFloat(5, vendaMedicamento.getReceita().getIdreceita());
			
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

}
