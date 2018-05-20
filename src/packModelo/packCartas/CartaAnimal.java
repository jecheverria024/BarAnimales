package packModelo.packCartas;

import packModelo.EnumColor;
import packModelo.Animal.Animal;
import packModelo.Animal.AnimalFactory;
import packModelo.Animal.IRecurrente;

public class CartaAnimal extends CartaGeneral implements Comparable<CartaAnimal> {
	private boolean camaleon = false;
	private int fuerza;
	private EnumColor color;
	private Animal animal;

	public CartaAnimal(String pImagen, int pFuerza, EnumColor pColor, Animal a) {
		super(pImagen);
		fuerza = pFuerza;
		color = pColor;
		animal = a;
		if (pFuerza == 5) {
			camaleon = true;
		}
	}

	public int getFuerza() {
		return fuerza;
	}

	public EnumColor getColor() {
		return color;
	}

	public String info() {
		return fuerza + " " + color.name();
	}

	public void ejecutarAnimalada() {
		this.animal.ejecutarAnimalada(fuerza, color.name());
	}

	@Override
	public int compareTo(CartaAnimal ca) {
		if (fuerza < ca.fuerza) {
			return 1;
		} else if (fuerza >= ca.fuerza) {
			return -1;
		}
		return 0;
	}

	public void esRecurrente() {
		if (this.animal instanceof IRecurrente) {
			((IRecurrente) this.animal).recurrir(fuerza, color.name());
		}
	}

	// true si la fuerza de entrada es menor
	// false si la fuerza es mayor
	public boolean compararFuerza(int pFuerza) {
		if (this.fuerza >= pFuerza) {
			return false;
		} else {
			return true;
		}
	}

	public boolean esCebra() {
		if (this.fuerza == 7) {
			return true;
		} else
			return false;
	}

	public boolean esCamaleon() {
		return camaleon;
	}

	public void ejecutarAnimaladaOtroAnimal(int pFuerza) {
		this.animal = AnimalFactory.getAnimalFactory().crearAnimal(pFuerza);
		this.fuerza = pFuerza;
		this.animal.ejecutarAnimalada(pFuerza, color.name());

	}

	public void volverASerCamaleon() {
		this.animal = AnimalFactory.getAnimalFactory().crearAnimal(5);
		this.fuerza = 5;
	}

	public boolean esColor(EnumColor pColor) {
		if (pColor.equals(color)) {
			return true;
		}
		return false;
	}

}
