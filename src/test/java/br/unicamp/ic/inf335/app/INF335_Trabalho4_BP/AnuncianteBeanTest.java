package br.unicamp.ic.inf335.app.INF335_Trabalho4_BP;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.regex.Pattern;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AnuncianteBeanTest {
	
	AnuncianteBean anunciante = null;
	
	@BeforeEach
	void init() {
		anunciante = new AnuncianteBean("Bruno Paulo", "123.456.789-00", null);
	}
	
	@Test
	void testNameIsNotNumeric() {
		assertEquals(this.isNumeric(anunciante.getNome()), false);
	}
	
	@Test
	void testCPFPattern() {
		assertEquals(this.validateCPFPattern(anunciante.getCPF()), true);
	}
	
	@Test
	void testAdicionarRemoverAnuncios() {
		int nAnunciosAposAdicionar; 
		int nAnunciosAposRemover; 
		
		ArrayList<AnuncioBean> anuncios = new ArrayList<AnuncioBean>();
		anunciante.setAnuncios(anuncios);
		
		ProdutoBean produto = new ProdutoBean("0001", "Produto A", "Produto A fictício para fins de teste unitário", 50.00, "Em estoque");
		AnuncioBean anuncio = new AnuncioBean(produto, null, 0.33);
		
		anunciante.addAnuncio(anuncio);
		nAnunciosAposAdicionar = anunciante.getAnuncios().size();
		
		anunciante.removeAnuncio(0);
		nAnunciosAposRemover = anunciante.getAnuncios().size();
		
		assertAll(
				() -> assertEquals(1, nAnunciosAposAdicionar),
			    () -> assertEquals(0, nAnunciosAposRemover)
			);
	}
	
	@Test
	void testMediaAnuncios() {
		ProdutoBean produto = null; 
		AnuncioBean anuncio = null;
		ArrayList<AnuncioBean> anuncios = new ArrayList<AnuncioBean>();
		
		produto = new ProdutoBean("0001", "Produto A", "Produto A fictício para fins de teste unitário", 50.00, "Em estoque");
		anuncio = new AnuncioBean(produto, null, 0.33);
		anuncios.add(anuncio);
		
		produto = new ProdutoBean("0002", "Produto B", "Produto B fictício para fins de teste unitário", 20.00, "Em estoque");
		anuncio = new AnuncioBean(produto, null, 0.1);
		anuncios.add(anuncio);
		
		produto = new ProdutoBean("0003", "Produto C", "Produto C fictício para fins de teste unitário", 10.00, "Em estoque");
		anuncio = new AnuncioBean(produto, null, 0.5);
		anuncios.add(anuncio);
		
		anunciante.setAnuncios(anuncios);
		
		assertEquals( ( (50.00-(50.00*0.33)) + (20.00-(20.00*0.1)) + (10.00-(10.00*0.5)) )/3 , anunciante.valorMedioAnuncios() );
	}
	
	private boolean isNumeric(String strValue) {
	    if(strValue == null){
	    	return false;
	    }
	    
	    try{
	    	double d = Double.parseDouble(strValue);
	    }
	    catch(NumberFormatException nfe){
	        return false;
	    }
	    
	    return true;
	}
	
	private boolean validateCPFPattern(String cpf) {
		Pattern pattern = Pattern.compile("^\\d{3}\\.?\\d{3}\\.?\\d{3}\\-?\\d{2}$");
		
	    if(cpf == null){
	    	return false;
	    }
	    
	    return pattern.matcher(cpf).matches();
	}
	
	
}