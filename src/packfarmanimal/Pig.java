package packfarmanimal;


/**
 * Clase que representa un tipo de animal, Pig.
 * @author abdu
 *
 */
public class Pig extends FarmAnimal implements Ecological{
	private boolean isEco;
	
	/**
	 * Constructora de la clase Pig.
	 * @param eName String Nombre del animal
	 * @param eAge	int Edad del animal
	 * @param eWeight	double Peso del animal
	 * @param eMySensor	Sensor Sensor del animal.
	 */
	public Pig(String eName, int eAge, double eWeight,boolean eEco) {
		
		super(eName,eAge,eWeight,1, 134.32*(0.035*eWeight));
		this.isEco = eEco;
		if(eEco) 
			this.setAnnualFoodPrice((134.32*(0.035*this.getWeight()))+((134.32*(0.035*this.getWeight()))*0.15));
	}
	
	@Override
	public String inheritancePath() {
		return "Pig" +" < " + super.inheritancePath(); 
	
	}
	
	@Override
	public boolean departure() {
		if((super.departure() || this.getWeight()>=100.0) && !this.possibleSick()) {
			return true;
		}return false;
	}

	

	@Override
	public boolean isEcological() {
		return this.isEco;
	}
	@Override
	public String toString() {
		return super.toString() + " " + this.isEco;
	}
	
}
