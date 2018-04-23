package packModelo.Animalada;

import packModelo.ColaEntrada;

public class AMofeta implements IAnimalada {

	@Override
	public void hacerAnimalada(int pFuerza, String pColor) {
		System.out.println("mofetaaaaaaaaaaa");
		int echados = 0;
		int fuerza = 12;
		boolean flag = !ColaEntrada.getColaEntrada().colaVacia();
		while (false == ColaEntrada.getColaEntrada().colaVacia() && flag && echados < 2) {
			if (fuerza > 1) {
				if (ColaEntrada.getColaEntrada().buscarPorFuerza(fuerza) > -1) {
					echados++;

					while (ColaEntrada.getColaEntrada().buscarPorFuerza(fuerza) > -1) {
						ColaEntrada.getColaEntrada()
								.echarPorPosicion(ColaEntrada.getColaEntrada().buscarPorFuerza(fuerza));
					}
				}
			} else {
				flag = false;
			}
			fuerza--;

		}

	}

}
