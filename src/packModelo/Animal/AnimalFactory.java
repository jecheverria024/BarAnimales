package packModelo.Animal;

public class AnimalFactory {
	private static AnimalFactory mAnimalFactory;

	public static AnimalFactory getAnimalFactory() {
		if (mAnimalFactory == null) {
			mAnimalFactory = new AnimalFactory();
		}
		return mAnimalFactory;
	}

	public Animal crearAnimal(int pTipo) {
		Animal unAnimal = null;
		if (pTipo == 12) {
			unAnimal = new Leon();
		} else if (pTipo == 11) {
			unAnimal = new Hipopotamo();
		} else if (pTipo == 10) {
			unAnimal = new Cocodrilo();
		} else if (pTipo == 9) {
			unAnimal = new Serpiente();
		} else if (pTipo == 8) {
			unAnimal = new Jirafa();
		} else if (pTipo == 7) {
			unAnimal = new Cebra();
		} else if (pTipo == 6) {
			unAnimal = new Foca();
		} else if (pTipo == 5) {
			unAnimal = new Camaleon();
		} else if (pTipo == 4) {
			unAnimal = new Mono();
		} else if (pTipo == 3) {
			unAnimal = new Canguro();
		} else if (pTipo == 2) {
			unAnimal = new Loro();
		} else if (pTipo == 1) {
			unAnimal = new Mofeta();
		}
		return unAnimal;
	}

}
