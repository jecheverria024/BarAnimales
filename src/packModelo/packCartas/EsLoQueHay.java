package packModelo.packCartas;

public class EsLoQueHay {
	private ListaCartas cartas;
	private static EsLoQueHay mEsLoQueHay;

	private EsLoQueHay() {
		cartas = new ListaCartas();
	}

	public static EsLoQueHay getEsLoQueHay() {
		if (mEsLoQueHay == null) {
			mEsLoQueHay = new EsLoQueHay();
		}
		return mEsLoQueHay;
	}

	public void addLast(CartaAnimal c) {
		cartas.add(c);
	}

	public ListaCartas getListCartas() {
		return cartas;
	}

	public void imprimir() {
		System.out.println("cartas en es lo que hay ");
		cartas.imprimirlista();
	}
}
