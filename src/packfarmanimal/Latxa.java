package packfarmanimal;



/**
 * Clase que define a las ovejas que producen leche.
 * @author abdu
 *
 */
public class Latxa extends Sheep{

	/**
	 * Constructora de la clase Latxa que son ovejas que producen leche.
	 * @param eName String Nombre del animal
	 * @param eAge	int Edad del animal
	 * @param eWeight	double Peso del animal
	 * @param eMySensor	Sensor Sensor del animal
	 */
	public Latxa(String eName, int eAge, double eWeight, boolean eEco) {
		super(eName, eAge, eWeight,"Milk",eEco);
		
	}
	
	@Override
	public String inheritancePath() {
		return "Latxa" +" < " + super.inheritancePath();

	}
	

}	
