package packTest;


import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import packModelo.ColaEntrada;
import packModelo.EnumColor;
import packModelo.Animal.*;
import packModelo.packCartas.*;

public class ColaEntradaTest {
	private ColaEntrada c= ColaEntrada.getColaEntrada();
	@Before
	public void setUp() throws Exception {
		c.add(new CartaAnimal(" ",3,EnumColor.ROJO, new Leon()));
		c.add(new CartaAnimal(" ",3,EnumColor.ROJO, new Leon()));
		c.add(new CartaAnimal(" ",3,EnumColor.ROJO, new Leon()));
		c.add(new CartaAnimal(" ",3,EnumColor.ROJO, new Leon()));
		c.add(new CartaAnimal(" ",3,EnumColor.ROJO, new Leon()));
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testComprobarColaCompleta() {
		assertTrue(c.revisarCola());
		
		//assertTrue(c.revisarCola());
		
	}

}
