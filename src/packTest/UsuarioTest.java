package packTest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import packModelo.EnumColor;

import packModelo.Usuario.Jugador;


public class UsuarioTest {
	Jugador jugador=new Jugador(EnumColor.AZUL);
	
	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testTieneCartas(){
		jugador.cogerCarta();	
		assertTrue(jugador.tieneCartas());
	}
	@Test
	public void testInicializarMazo() {
		assertTrue(jugador.getListaManos().longitud()==0);
	}
	
}
