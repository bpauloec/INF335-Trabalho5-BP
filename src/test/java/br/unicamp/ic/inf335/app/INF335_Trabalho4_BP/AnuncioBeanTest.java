package br.unicamp.ic.inf335.app.INF335_Trabalho4_BP;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AnuncioBeanTest {

	private ProdutoBean produtoA = new ProdutoBean("0001", "Produto A", "Produto A fictício para fins de teste unitário", 50.00, "Em estoque");
	private AnuncioBean anuncio = new AnuncioBean(produtoA, null, 0.3);
	
	@Test
	void testGetValorComDesconto30porCento() {
		anuncio.setDesconto(0.30);
		assertEquals((50.00 - (50.00*0.3)), anuncio.getValor());
	}
	
	@Test
	void testGetValorSemDesconto() {
		anuncio.setDesconto(0.00);
		assertEquals((50.00 - (50.00*0)), anuncio.getValor());
	}
}
