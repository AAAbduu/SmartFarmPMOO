package packfarmanimal;


/**
 * Clase que representa el objeto Horse.
 * @author abdu
 *
 */
public class Horse extends FarmAnimal{
	
private String descActivity;
	
	
	/**
	 * Constructora de la clase Horse.
	 * @param eName String Nombre del animal
	 * @param eAge	int Edad del animal
	 * @param eWeight	double Peso del animal
	 * @param eMySensor	Sensor Sensor del animal.
	 * @param eDescActivity	Producto que producen estos animales
	 */
	public Horse(String eName, int eAge, double eWeight, 
 String eDescActivity) {
		super(eName,eAge,eWeight,5, 1027.75*(0.01*eWeight));
		this.descActivity = eDescActivity;
	}
	
	@Override
	public String inheritancePath() {
		return "Horse" +" < " + super.inheritancePath(); 
	
	}
	@Override
	public boolean departure() {
		if(super.departure() && !this.possibleSick()) {
			return true;
		}return false;
	}
	
	@Override
	public String toString() {
		return super.toString() + " " + this.descActivity;
	}
	

}
