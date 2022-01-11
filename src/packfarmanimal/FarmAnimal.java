
/**
 *FarmAnimal es una clase que crea y manipula objetos de tipo FarmAnimal,
 *que consisten en simulaciones de animales que  poseen caracteristicas
 *como nombre, peso, edad y un sensor para monitorizarlos.
 *
 * @project : @SmartFarming
 * @author : @Abdu
 */


package packfarmanimal;

import packfarm.*;
import java.io.FileWriter;
import java.io.IOException;

import packexceptions.CollectErrorException;

public abstract  class FarmAnimal implements Comparable {
	private String name;
	private int age;
	private double weight;
	private Sensor mySensor;
	private PhysiologicalValues [] myValues;
	private int arrayPos = 0;
	private double temp = 39.0;
	private int departureAge;
	private double annualFoodPrice;
	
	
	
	
	
	/**
	 * Constructora de la clase que general un FarmAnimal recibiendo 4 parametros,
	 * el nombre del animal, su edad, su peso y un sensor para monitorizarlo.
	 * @param eName Nombre del animal 
	 * @param eAge Edad del Animal
	 * @param eWeight Peso del Animal
	 * @param eMySensor Sensor que lleva el animal
	 * @param eDepartureAge Edad a la que se debe marchar el animal
	 * @param eAnnualFoodPrice Coste anual del animal en comida.
	 */
	public FarmAnimal(String eName, int eAge, double eWeight, int eDepartureAge, double eAnnualFoodPrice) {
		this.name = eName;
		this.age = eAge;
		this.weight = eWeight;
		this.myValues = new PhysiologicalValues [7];
		this.arrayPos = 0;
		this.annualFoodPrice = eAnnualFoodPrice;
		this.departureAge = eDepartureAge;
	}
	
	/**
	 * Devuelve la edad de partida de un animal
	 * @return int Edad de partida
	 */
	public int getDepartureAge() {
		return departureAge;
	}

	/**
	 * Permite definir la edad de partida de un animal
	 * @param departureAge Edad de partida a definir.
	 */
	public void setDepartureAge(int departureAge) {
		this.departureAge = departureAge;
	}

	/**
	 * Permite conocer el coste anual de un animal en comida
	 * @return double Coste anual en comida de un animal.
	 */
	public double calculateAnnualCost() {
		return annualFoodPrice;
	}

	/**
	 * Permite asignar un coste anual a un animal.
	 * @param annualFoodPrice Coste anual a asignar.
	 */
	public void setAnnualFoodPrice(double annualFoodPrice) {
		this.annualFoodPrice = annualFoodPrice;
	}


	/**
	 * Funcion que devuelve el nombre de un FarmAnimal.
	 * @return String Nombre del FarmAnimal.
	 */
	public String getName() {
		return this.name;
	
	}
	
	/**
	 * Funcion que devuelve la edad de un FarmAnimal.
	 * @return int Edad del FarmAnimal.
	 */
	
	public int getAge() {
		return this.age;
	
	}
	
	
	/**
	 * Funcion que devuelve el peso de un FarmAnimal.
	 * @return double Peso del FarmAnimal.
	 */
	public double getWeight() {
		return this.weight;
	
	}
	
	
	/**
	 * Funcion que devuelve el Sensor de un FarmAnimal.
	 * @return Sensor Sensor del FarmAnimal.
	 */
	public Sensor getMySensor() {
		return this.mySensor;
	
	}
	/**
	 * Funcion que indica si un animal ah superado su edad de estancia.
	 * @return boolean Indica si ya se ha superado la edad.
	 */
	public boolean departure() {
		if(this.age>=this.departureAge) {
			return true;
		}return false;
	}
	
	
	/**
	 * Funcion que devuelve la temperatura habitual de un animal.
	 * @return double Temperatura habitual.
	 */
	public double getUsualTemperature() {
		return this.temp;
	}
	/**
	 * Metodo que permite poner otra temperatura habitual en caso de necesidad.
	 * @param temp double Temperatura a colocar.
	 */
	public void setTemp(double temp) {
		this.temp = temp;
	}
	
	/**
	 * Funcion que permite conocer si un animal esta posiblemente enfermo.
	 * @return boolean Si el animal esta enfermo se devovlera true, sino false.
	 */
	public boolean possibleSick() {
		if((this.avgTemperature()-this.getUsualTemperature()>1.5)||(this.avgTemperature()-this.getUsualTemperature()< -1.5)) {
			return true;
		}return false;
	}
	
	
	/**
	 * Funcion que devuelve los valores fisiologicos almacenados de un FarmAnimal.
	 * @return PhysiologicalValues [] Valores fisiologicos almacenados del FarmAnimal.
	 */
	
	public PhysiologicalValues [] getPhyisiologicalValues() {
		return this.myValues;
	}
	
	
	/**
	 * Metodo que permite asignarle la edad a un FarmAnimal.
	 */
	public void setAge(int eAge) {
		this.age = eAge;
	
	}
	
	
	/**
	 * Metodo que permite asignarle el peso a un FarmAnimal.
	 */
	public void setWeight(double eWeight) {
		this.weight = eWeight;
	}
	
	/**
	 * Metodo que permite asignarle un Sensor a un FarmAnimal.
	 */
	public void setMySensor(Sensor eMySensor) {
		this.mySensor = eMySensor;
	}
	
	/**
	 * Funcion que devuelve el numero del registro que se quiere realizar.
	 * @return int Registro que se va a realizar la proxima vez.
	 */
	
	public int getArrayPos() {
		return this.arrayPos;
	}
	
	/**
	 *Funcion que devuelve todos los valores caracteristicos de FarmAnimal.
	 *@return String Valores caracteristicos de FarmAnimal.
	 */
	@Override
	public String toString() {
		return "nombre: " + this.name +" edad: " + this.age+" peso: "+this.weight+" Sensor_id: "+this.mySensor.toString();
	
	}
	/**
	 * Funcion que devuelve el nombre de la clase, se ira incrementando poco a poco en las clases hijas.
	 * @return String Nombre de la clase.
	 */
	public String inheritancePath() {
		return "FarmAnimal";
	}
	
	
	/**
	 * Funcion que registra los valores fisiologicos de un FarmAnimal durante un dia y los devuelve.
	 * Tambien se encarga de comprobar si han pasado 7 dias, si es asi, registra en un fichero .txt 
	 * los valores registrados durante los 7 dias y prepara el sensor del animal para los proximos 7 dias.
	 * @return PhysiologicalValues Valores registrados durante ese dia.
	 */
	public PhysiologicalValues register() {
		PhysiologicalValues valHoy=null;
		boolean recogido = false;
		if(this.arrayPos > 6) {
			try {
				storeValuesInFile();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			initWeek();
		}
		while(recogido==false) {
		try {
			valHoy = this.mySensor.collectValues(this.getUsualTemperature());
			recogido = true;
		} catch (CollectErrorException e) {
			System.out.println("ERROR AL RECOLECTAR para el animal " + this.name);
			System.out.println("Aunque haya fallado he insistido y capturado para el animal:" + this.name);
			
		}}
		
		this.myValues[this.arrayPos] = valHoy;
		this.arrayPos++;
		return valHoy;
	}
	
	/**
	 * Funcion que calcula la temperatura media del animal segun la cantidad de dias que lleva
	 * en la granja. Si no se encuentran datos, devolvera un 0.
	 * @return dobule Temperatura media del animal durante los dias en la granja o 0 si no existen tales datos.
	 */
	public double avgTemperature() {
		double avgTe=0.0;
		if(this.arrayPos == 0) {
			return 0.0;
		}else {
			for(PhysiologicalValues c : this.myValues) {
				if(c!=null) {
				avgTe = (avgTe + c.getTemperature());
			}}
		}
		return (avgTe/(this.arrayPos));
	}
	
	/**
	 * Funcion que permite conocer, dado el nombre de un animal, si se esta refiriendo al mismo.
	 * @param eName Nombre del animal.
	 * @return boolean Si es el mismo animal, devolvera True, en caso contrario, False.
	 */
	public boolean equals(String eName){
		if(this.name.equals(eName)) {
			return true;
		}
		return false;
	
	}
	
	
	/**
	 * Metodo que se encarga de registrar en un fichero externo, los valores fisiologicos de un animal.
	 * 
	 * @throws IOException Si falla al crear el fichero.
	 */
	public void storeValuesInFile() throws IOException {
		FileWriter archivo = new FileWriter("data/historicalValues.txt",true);
		archivo.write(this.toString());
		archivo.write("\n");
		for(PhysiologicalValues c : this.myValues) {
			archivo.write(c.toString());
			archivo.write("\n");
		}
		
		archivo.close();
	}
	
	@Override
	public int compareTo(Object eFarmAnimal) {
		FarmAnimal aux = (FarmAnimal) eFarmAnimal;
		int objAux = Integer.valueOf(aux.getMySensor().toString().split("ID")[1]);
		int thisNum = Integer.valueOf(this.getMySensor().toString().split("ID")[1]);
		
		if(thisNum<objAux) {
			return -1;
		}else if(thisNum > objAux) {
			return 1;
		}
		
		return 0;
	}
	
	/**
	 * Metodo que se encarga de preparar al Sensor del animal una vez transcurridos 7 dias.
	 * 
	 */
	public void initWeek() {
	this.arrayPos = 0;
	this.myValues = new PhysiologicalValues [7];
	}
}
