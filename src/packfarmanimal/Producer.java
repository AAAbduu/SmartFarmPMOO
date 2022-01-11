package packfarmanimal;


/**
 * Clase que define a los animales que producen productos.
 * @author abdu
 *
 */
public abstract class Producer extends FarmAnimal implements Ecological{
	private String product;
	private boolean isEco;
	
	/**
	 * Constructora de la clase Producer abstracta.
	 * @param eName String Nombre del animal
	 * @param eAge	int Edad del animal
	 * @param eWeight	double Peso del animal
	 * @param eMySensor	Sensor Sensor del animal
	 * @param eDepartureAge	int Edad a la cual el animal debe marcharse
	 * @param eAnnualFoodPrice	double Coste anual del animal
	 * @param eProduct	Producto que producen estos animales
	 */
	public Producer(String eName, int eAge, double eWeight, int eDepartureAge, double eAnnualFoodPrice, String eProduct, boolean eEco) {
		super(eName,eAge,eWeight, eDepartureAge, eAnnualFoodPrice);
		this.product = eProduct;
		this.isEco = eEco;
		if(eEco) this.setAnnualFoodPrice(this.calculateAnnualCost()+(0.02*this.calculateAnnualCost()));
	}
	
	@Override
	public String inheritancePath() {
		return "Producer" +" < " + super.inheritancePath(); 
	
	}
	
	@Override
	public boolean isEcological() {
		return this.isEco;
	}
	@Override
	public String toString(){
		return super.toString() + " " + this.product + " " + this.isEco;
	}
}
