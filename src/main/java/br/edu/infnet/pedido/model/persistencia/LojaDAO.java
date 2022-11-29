package br.edu.infnet.pedido.model.persistencia;

import br.edu.infnet.pedido.model.entidade.Loja;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LojaDAO extends JdbcDAO<Loja>  {

	public LojaDAO() {
	}
	
	@Override
	public Boolean salvar(Loja loja) {
		String sql = "insert into loja(nome, codigo) values (?,null)";
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, loja.getNome()); //sql injection
			return pstm.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Boolean atualizar(Loja loja) {
		String sql = "update loja set nome = ? where codigo = ?";
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, loja.getNome());
			pstm.setLong(2, loja.getCodigo());
			return pstm.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public Boolean deletar(Loja loja) {
		String sql = "delete from loja where codigo = ?";
		try {
			pstm = con.prepareStatement(sql);
			pstm.setLong(1, loja.getCodigo());
			return pstm.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Loja obter(Long codigo){
		String sql = "select * from loja where codigo = ?";
		Loja loja = new Loja();
		try {
			pstm = con.prepareStatement(sql); 
			pstm.setLong(1, codigo); 
			rs = pstm.executeQuery();
			if(rs.next()) {
				String nome = rs.getString("nome");
				Long codigoDB = rs.getLong("codigo");
				loja = new Loja(nome, codigoDB);
			}
			return loja;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Loja> listarTodos(){
		String sql = "select * from loja";
		List<Loja> lojas = new ArrayList<>();
		try {
			stm = con.createStatement();
			rs = stm.executeQuery(sql);
			while(rs.next()) {
				String nome = rs.getString("nome");
				Long codigo = rs.getLong("codigo");
				Loja loja = new Loja(nome, codigo);
				lojas.add(loja);
			}
			return lojas;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
