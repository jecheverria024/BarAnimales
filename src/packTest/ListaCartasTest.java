package packTest;



import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import packModelo.EnumColor;
import packModelo.Animal.Leon;
import packModelo.packCartas.CartaAnimal;
import packModelo.packCartas.EsLoQueHay;
import packModelo.packCartas.ListaCartas;
import packModelo.packCartas.PuertaDelCielo;

public class ListaCartasTest {
	ListaCartas c= new ListaCartas();
	EsLoQueHay c1= EsLoQueHay.getEsLoQueHay();
	PuertaDelCielo c2= PuertaDelCielo.getPuertaDelCielo();
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
	
	public void testDosCartas(){
		c.DosPrimeras();
		assertTrue(c2.getCartas().longitud()==2);
		
	}
	@Test
	public void testUltimaCarta(){
		c.ultimaCarta();
		assertTrue(c1.getListCartas().longitud()==1);
	}
}
