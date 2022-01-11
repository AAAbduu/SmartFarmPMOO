package packfarmanimal;


/**
 * Clase que representa a animales Chicken.
 * @author abdu
 *
 */


public class Chicken extends Producer implements Ecological{
	/**
	 * Constructora de la clase Chicken.
	 * @param eName String Nombre del animal
	 * @param eAge	int Edad del animal
	 * @param eWeight	double Peso del animal
	 * @param eMySensor	Sensor Sensor del animal
	 */
	public Chicken(String eName, int eAge, double eWeight, boolean eEco)  {
		super(eName, eAge, eWeight, 4, 547.5, "Eggs", eEco);
		this.setTemp(42.0);
	}
	
	@Override
	public String inheritancePath() {
		return "Chicken" +" < " + super.inheritancePath(); 
	
	}

	@Override
	public boolean isEcological() {
		return super.isEcological();
	}
	@Override
	public String toString() {
		return super.toString() + " " + super.isEcological();
	}
	

	
	
	
	

}
