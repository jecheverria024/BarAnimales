package packModelo.packCartas;

public class PuertaDelCielo {
	private ListaCartas cartas;
	private static PuertaDelCielo mPuertaDelCielo;

	private PuertaDelCielo() {
		cartas = new ListaCartas();
	}

	public static PuertaDelCielo getPuertaDelCielo() {
		if (mPuertaDelCielo == null) {
			mPuertaDelCielo = new PuertaDelCielo();
		}
		return mPuertaDelCielo;
	}

	public void add(CartaAnimal carta) {
		cartas.add(carta);
	}

	public void imprimir() {
		System.out.println("Lista de cartas en la puerta del cielo");
		cartas.imprimirlista();
	}
}
