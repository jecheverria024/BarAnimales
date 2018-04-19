package packModelo.Animalada;

import java.util.Scanner;

import packModelo.ColaEntrada;
import packModelo.packCartas.CartaAnimal;
import packModelo.packCartas.ListaCartas;

public class ACanguro implements IAnimalada {

	@Override
public void hacerAnimalada(int pFuerza, String pColor) {
		int num;
		
		Scanner sc= new Scanner(System.in);
		System.out.println("Inserta un 1 o un 2 para Saltar 1 o 2 Cartas");
		//falta implementar para que seleccionen un numero desde la interfaz
		num=sc.nextInt();
		this.saltar(num);

	}

	private void saltar(int num){
		ColaEntrada.getColaEntrada().getLista().avanzarCartaCanguro(num);
		
	}
}
