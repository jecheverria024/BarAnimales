package packModelo;

import java.util.concurrent.TimeUnit;

import packModelo.Usuario.Jugador;
import packModelo.Usuario.Ordenador;
import packModelo.packCartas.CartaAnimal;
import packModelo.packCartas.EsLoQueHay;
//import packModelo.packBarcos.BarcoNoEncException;
import packModelo.packCartas.ListaCartas;
import packModelo.packCartas.PuertaDelCielo;
import packModelo.Usuario.Jugador;

public class BarBestial {
	private static BarBestial mBarBestial;
	private boolean turno; // true = Usuario, false = Ordenador
	private boolean juegoFinalizado;
	private Jugador jugador;
	private Ordenador ordenador;
	private BarBestial() {	
	}

	public static BarBestial getBarBestial() {
		if (mBarBestial == null) {
			mBarBestial = new BarBestial();
		}
		return mBarBestial;
	}

	public void iniciarPartida() {
		this.inicializarPartida();
		this.repartirCartas();
	}
	public boolean esTurnoJugador() {
		return turno;
	}
	private void inicializarPartida() {
		ColaEntrada.getColaEntrada();
		PuertaDelCielo.getPuertaDelCielo();
		this.jugador = new Jugador(EnumColor.AZUL);
		this.ordenador = new Ordenador(EnumColor.VERDE);
		turno = true;
		juegoFinalizado = false;
		imprimirmazo();
	}

	public boolean jugar(int pos) {
		jugador.echarCarta(pos);
		
		cambiarTurno();
		if (ordenador.tieneCartas()) {
			
			ordenador.jugar();
			
			cambiarTurno();
		}
		if (!jugador.tieneCartas() && !ordenador.tieneCartas()) {
			this.finalizarPartida();
			this.juegoFinalizado = true;
		}
	
		return juegoFinalizado;
	}
	
	private void cambiarTurno() {
		turno=!turno;
	}
	private void repartirCartas() {
		jugador.barajar();
		ordenador.barajar();
		for (int i = 0; i < 4; i++) {
			jugador.cogerCarta();
			ordenador.cogerCarta();
		}
	}

	/*
	 * public void echarCarta(int pi) { if(!jugador.echarCarta(pi)) {
	 * if(finalizarPartida()) { juegoFinalizado=true; } }
	 * 
	 * }
	 */
	// aqui hay dudas
	public Jugador getJugador() {
		return this.jugador;
	}
	public String infoMano() {
		return this.jugador.infoMano();
	}
	private void finalizarPartida() {
		/*
		 * if (Jugador.getJugador().getPuntos() > Ordenador.getOrdenador().getPuntos())
		 * { System.out.println("el jugador" + Jugador.getJugador().getNombre() +
		 * "ha ganado"); } else System.out.println("el ordenador ha ganado");
		 * this.juegoFinalizado = true;
		 */
		System.out.println("PARTIDA FINALIZADA");
		EsLoQueHay.getEsLoQueHay().imprimir();
		PuertaDelCielo.getPuertaDelCielo().imprimir();
		ColaEntrada.getColaEntrada().imprimir();
	}

	private void imprimirmazo() {
		System.out.println("jugador");
		jugador.imprimirmazo();
		System.out.println("ordenador");
		ordenador.imprimirmazo();
	}
}
