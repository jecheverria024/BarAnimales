package packModelo;

import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import packModelo.Usuario.Jugador;
import packModelo.Usuario.Ordenador;
import packModelo.packCartas.CartaAnimal;
import packModelo.packCartas.EsLoQueHay;
//import packModelo.packBarcos.BarcoNoEncException;
import packModelo.packCartas.ListaCartas;
import packModelo.packCartas.PuertaDelCielo;
import packRanking.GestorRanking;
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

	public void iniciarPartida(String pJugador) {
		this.inicializarPartida(pJugador);
		this.repartirCartas();
	}

	public boolean esTurnoJugador() {
		return turno;
	}

	private void inicializarPartida(String pJugador) {
		ColaEntrada.getColaEntrada();
		PuertaDelCielo.getPuertaDelCielo();
		this.jugador = new Jugador(EnumColor.AZUL, pJugador);
		this.ordenador = new Ordenador(EnumColor.VERDE);
		turno = true;
		juegoFinalizado = false;
		imprimirmazo();
	}

	public boolean jugar(int pos) {
		jugador.echarCarta(pos);

		cambiarTurno();
		if (ordenador.tieneCartas()) {
			JFrame frame = new JFrame("Ordenador");
			JOptionPane.showMessageDialog(frame, "Turno del ordenador","Ordenador", JOptionPane.INFORMATION_MESSAGE);
	
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
		turno = !turno;
	}

	private void repartirCartas() {
		jugador.barajar();
		ordenador.barajar();
		for (int i = 0; i < 4; i++) {
			jugador.cogerCarta();
			ordenador.cogerCarta();
		}
	}

	// aqui hay dudas
	public Jugador getJugador() {
		return this.jugador;
	}

	public String infoMano() {
		return this.jugador.infoMano();
	}

	private void finalizarPartida() {
		JFrame frame = new JFrame("PARTIDA FINALIZADA");
		JOptionPane.showMessageDialog(frame, "El ganador es " + PuertaDelCielo.getPuertaDelCielo().calcularGanador());
		EsLoQueHay.getEsLoQueHay().imprimir();
		PuertaDelCielo.getPuertaDelCielo().imprimir();
		ColaEntrada.getColaEntrada().imprimir();
		int puntos=100; //AQUI PONER EL METODO PARA CALCULAR PUNTOS 
		this.almacenarRanking(puntos);
	}

	private void almacenarRanking(int puntos) {
		this.jugador.almacenarRanking(puntos);
		
	}

	

	private void imprimirmazo() {
		System.out.println("jugador");
		jugador.imprimirmazo();
		System.out.println("ordenador");
		ordenador.imprimirmazo();
	}
}
