package br.edu.infnet.pedido.model.persistencia;

import br.edu.infnet.pedido.model.entidade.Loja;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class LojaDAOTest {
	
	@Before
	public void inicializar() {
		IDAO lojaDAO = new LojaDAO();
		Loja loja = new Loja("Loja do Jose das Couves");
		lojaDAO.salvar(loja);
	}
	
	
	@Test
	public void test() {
		IDAO lojaDAO = new LojaDAO();
		Loja loja = new Loja("Loja do Jose das Couves");
		boolean validacao = lojaDAO.salvar(loja);
		Assert.assertTrue(validacao);
	}
	
	
	@Test
	public void testUpdate() {
		IDAO lojaDAO = new LojaDAO();
		List<Loja> lista = lojaDAO.listarTodos();
		Loja loja = new Loja("Loja da Maria das Couves", lista.get(0).getCodigo());
		boolean validacao = lojaDAO.atualizar(loja);
		Assert.assertTrue(validacao);
	}
	
	@Test
	public void testDelete() {
		IDAO lojaDAO = new LojaDAO();
		List<Loja> lista = lojaDAO.listarTodos();
		Loja loja = new Loja("Loja da Maria das Couves", lista.get(lista.size()-1).getCodigo());
		boolean validacao = lojaDAO.deletar(loja);
		Assert.assertTrue(validacao);
	}
	
	
	@Test
	public void testListaLojas() {
		IDAO lojaDAO = new LojaDAO();
		List<Loja> lista = lojaDAO.listarTodos();
		Assert.assertTrue(lista.size() > 0);
	}
	

	@Test
	public void testObterLoja() {
		IDAO lojaDAO = new LojaDAO();
		List<Loja> lista = lojaDAO.listarTodos();
		Object loja = lojaDAO.obter(lista.get(0).getCodigo());
		Assert.assertNotNull(loja);;
	}
	

}
