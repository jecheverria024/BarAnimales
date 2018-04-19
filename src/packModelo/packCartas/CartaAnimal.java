package packModelo.packCartas;

import packModelo.EnumColor;
import packModelo.Animal.Animal;

public class CartaAnimal extends CartaGeneral implements Comparable<CartaAnimal> {
	private int fuerza;
	private EnumColor color;
	private Animal animal;

	public CartaAnimal(String pImagen, int pFuerza, EnumColor pColor, Animal a) {
		// TODO Auto-generated constructor stub
		super(pImagen);
		// TODO Auto-generated constructor stub
		fuerza = pFuerza;
		color = pColor;
		animal = a;
	}

	public int getFuerza() {
		return fuerza;
	}

	public EnumColor getColor() {
		return color;
	}
	public String info() {
		return fuerza+" "+color.name();
	}
	public void ejecutarAnimalada() {
		
		this.animal.ejecutarAnimalada(fuerza, color.name());
	}

	@Override
	public int compareTo(CartaAnimal ca) {
		if (fuerza < ca.fuerza) {
            return 1;
        }
		else if (fuerza >= ca.fuerza) {
            return -1;
        }
        return 0;
	}
	
	public boolean esRecurrente() {
		if (this.fuerza==11 || this.fuerza==10 || this.fuerza==8 || this.fuerza==7){
			return true;
		}
		else 
			return false;
	}	
}
