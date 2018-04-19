package packObservable;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class ObservableAbstracto {
	private ArrayList<IObserver> observadores;

	public ObservableAbstracto() {
		observadores = new ArrayList<IObserver>();
	}

	public void registrarObservador(IObserver pObserver) {
		if (!observadores.contains(pObserver)) {
			observadores.add(pObserver);
		}
	}

	public void eliminarObservador(IObserver pObserver) {
		if (observadores.contains(pObserver)) {
			observadores.add(pObserver);
		}
	}

	public void notificar(ObservableAbstracto pOA, Object o) {
		Iterator<IObserver> it = observadores.iterator();
		while (it.hasNext()) {
			it.next().update(pOA,o);
		}
	}
}
