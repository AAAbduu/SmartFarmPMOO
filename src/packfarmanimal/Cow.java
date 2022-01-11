package packfarmanimal;




/**
 * Clase que representa a los animales Cow.
 * @author abdu
 *
 */
public class Cow extends Producer{
	
	/**
	 * Constructora de la clase Cow.
	 * @param eName String Nombre del animal
	 * @param eAge	int Edad del animal
	 * @param eWeight	double Peso del animal
	 * @param eMySensor	Sensor Sensor del animal
	 */
	public Cow(String eName, int eAge, double eWeight, boolean eEco)  {
		super(eName, eAge, eWeight,  20, 492.75, "Milk",eEco);
		
	}
	@Override
	public String inheritancePath() {
		return "Cow" +" < " + super.inheritancePath();

	}
}	
