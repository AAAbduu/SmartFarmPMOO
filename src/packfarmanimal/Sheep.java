package packfarmanimal;


/**
 * Clase que caracteriza a las ovejas.
 * @author abdu
 *
 */

public abstract class Sheep extends Producer{

	/**
	 * Constructora de la clase Sheep abstracta.
	 * @param eName String Nombre del animal
	 * @param eAge	int Edad del animal
	 * @param eWeight	double Peso del animal
	 * @param eMySensor	Sensor Sensor del animal
	 * @param eProduct String Producto que producen las ovejas.
	 */
	public Sheep(String eName, int eAge, double eWeight,
			String eProduct, boolean eEco) {
		super(eName, eAge, eWeight, 12, 133.23, eProduct, eEco);
	}
	
	@Override
	public String inheritancePath() {
		return "Sheep" +" < " + super.inheritancePath();

	}
	
	
}
