package packfarmanimal;

/**
 * Clase que caracteriza a las ovejas productoras de lana.
 * @author abdu
 *
 */
public class WoolSheep extends Sheep {
	
	/**
	 * Constructora de la clase Latxa que son ovejas que producen leche.
	 * @param eName String Nombre del animal
	 * @param eAge	int Edad del animal
	 * @param eWeight	double Peso del animal
	 * @param eMySensor	Sensor Sensor del animal
	 */
	public WoolSheep(String eName, int eAge, double eWeight, boolean eEco) {
		super(eName, eAge, eWeight, "Wool", eEco);
		
	}
	
	@Override
	public String inheritancePath() {
		return "WoolSheep" +" < " + super.inheritancePath();

	}

	

}
