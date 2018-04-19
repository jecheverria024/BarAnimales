package packTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import packModelo.BarBestial;
import packModelo.EnumColor;
import packModelo.Animal.Leon;
import packModelo.Usuario.Jugador;
import packModelo.Usuario.Ordenador;
import packModelo.packCartas.CartaAnimal;

public class BarBestialTest {
	Jugador jug=new Jugador(EnumColor.AZUL);
	Ordenador ord=new Ordenador(EnumColor.AMARILLO);

	@Before
	public void setUp() throws Exception {
		
	}
	@Test
	public void test() {
		fail("Not yet implemented");
	}
	public void testRepartirCartas() {
		//no se como hacer porque es un metodo privado
	}
	

}
