package br.unicamp.ic.inf335.app.INF335_Trabalho4_BP;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ProdutoBeanTest {

	private ProdutoBean produtoA = new ProdutoBean("0001", "Produto A", "Produto A fictício para fins de teste unitário", 50.00, "Em estoque");
	private ProdutoBean produtoB = new ProdutoBean("0002", "Produto B", "Produto B fictício para fins de teste unitário", 10.00, "Em estoque");
	
	@Test
	@DisplayName("Test compareTo - Product A value greater than Product B value")
	void testCompareToAGreaterB() {
		produtoA.setValor(50.00);
		produtoB.setValor(10.00);
		assertEquals(1, produtoA.compareTo(produtoB));
	}

	@Test
	@DisplayName("Test compareTo - Product A value less than Product B value")
	void testCompareToALessB() {
		produtoA.setValor(5.00);
		produtoB.setValor(10.00);
		assertEquals(-1, produtoA.compareTo(produtoB));
	}
	
	@Test
	@DisplayName("Test compareTo - Product A value equals than Product B value")
	void testCompareToAEqualsB() {
		produtoA.setValor(10.00);
		produtoB.setValor(10.00);
		assertEquals(0, produtoA.compareTo(produtoB));
	}
}
