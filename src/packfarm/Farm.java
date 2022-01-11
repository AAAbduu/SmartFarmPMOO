/**
 *Farm es una clase con patron Singleton que crea y manipula un unico objeto Farm,
 *que consiste en una simulacion de una granja que  posee caracteristicas
 *como una lista de animales y una lista de sensores.
 *
 * @project : @SmartFarming
 * @author : @Abdu
 */

package packfarm;
import packfarmanimal.*;
import java.util.ArrayList;
import java.util.Collections;

import packexceptions.UnknownFarmAnimalException;

public class Farm {
	private ArrayList <FarmAnimal> farmAnimalSet;
	private ArrayList <Sensor> sensorList;
	private static Farm instance;
	private static final Sensor ChickenSENSOR = new Sensor("ID00");
	
	
	private Farm() {
		this.farmAnimalSet = new ArrayList <FarmAnimal>();
		this.sensorList = new ArrayList <Sensor>();
	}
	
	
	/**
	 * Funcion que implementa parte del patron Singleton, consiste en que solo
	 * exista un unico objeto de tipo Farm y no se puedan crear otros,
	 * esta funcion va a devolver siempre el mismo objeto Farm.
	 * @return Farm  Unica instancia existente de Farm.
	 */
	public static Farm getFarmInstance() {
		if(instance == null) {
			instance = new Farm();
		}
		return instance;
	
	}
	
	
	/**
	 * Metodo que se encarga de destruir la unica instancia de la clase.
	 */
	public void destroy() {
		instance = null;
	}
	
	/**
	 * Metodo que dados el nombre, la edad y el peso de un animal, se le anade
	 * a la granja asignandole un Sensor de la lista de sensores disponibles.
	 * @param eName Nombre del animal
	 * @param eAge Edad del animal
	 * @param eWeight Peso del animal
	 * @throws IndexOutOfBoundsException En caso de no encontrar sensores disponibles.
	 */
	public void addFarmAnimal(FarmAnimal eFarmAnimal)throws IndexOutOfBoundsException {
		if(this.sensorList.size()==0) throw new IndexOutOfBoundsException();
		this.farmAnimalSet.add(eFarmAnimal);
		if(eFarmAnimal instanceof Chicken) {
			eFarmAnimal.setMySensor(ChickenSENSOR);
		}else {
			eFarmAnimal.setMySensor(this.sensorList.get(0));
			this.sensorList.remove(0);
		}
		
	
	}
	//un caso de anadir un animal y comprobar que esta en la granja
	//un caso de throw con que no hay sensores
	
	
	/**
	 * Funcion que permite averiguar el numero de animales que hay en la granja.
	 * @return int Numero de animales en la granja
	 */
	public int howManyAnimals() {
		return this.farmAnimalSet.size();
	
	}
	
	public ArrayList <FarmAnimal> getAnimalList(){
		return this.farmAnimalSet;
	}
	
	
	/**
	 * Metodo que permite anadir un Sensor a la lista de sensores disponibles.
	 * @param eSensor Sensor que se quiere anadir a la lista.
	 */
	public void addSensor(Sensor eSensor) {
		this.sensorList.add(eSensor);
	
	}
	
	/**
	 * Funcion que permite averiguar el numero de sensores disponibles.
	 * @return int Numero de sensores disponibles.
	 */
	public int howManySensors() {
		return this.sensorList.size();
	
	}
	
	/**
	 * Metodo que solicita e imprime por pantalla los valores fisiologicos de todos
	 * los animales de la granja en el dia actual.
	 */
	public void register() {
		for(FarmAnimal c : this.farmAnimalSet) {
			System.out.println(c.getName());
			System.out.println(c.register());
		}
	
	}
	
	
	/**
	 * Funcion que dado una temperatura, busca si algun animal de la granja
	 * supera dicha temperatura y lo registra en una lista para ser 
	 * devuelta posteriormente con todos los animales posiblemente enfermos.
	 * @param eMaxTemp Temperatura dada que si se supera, se anade el animal a la lista.
	 * @return FarmAnimal [] Lista con los animales posiblemente enfermos.
 	 */
	public ArrayList <FarmAnimal> obtainPossiblySick() {
		
		ArrayList <FarmAnimal> sickAnimals = new ArrayList <FarmAnimal>();
	
		for(FarmAnimal c: this.farmAnimalSet) {
			if(c.possibleSick()) {
				sickAnimals.add(c);
		}
	}
		return sickAnimals;
}
		
	
	
	/**
	 * Funcion que permite encontrar a un animal dado su nombre.
	 * @param eName Nombre del animal que se busca
	 * @return FarmAnimal Animal buscado por nombre.
	 * @throws UnknownFarmAnimalException Excepcion que se lanza en caso de no encontrar al animal.
	 */
	
	public FarmAnimal obtainFarmAnimal(FarmAnimal eFarmAnimal) throws UnknownFarmAnimalException {
		for(FarmAnimal c : this.farmAnimalSet) {
			if(c.getName().equals(eFarmAnimal.getName())) {
				return c;
			}
		}
		throw new UnknownFarmAnimalException();
	
	}
	/**
	 * Funcion que permite eliminar y obtener un animal de la granja dado su nombre.
	 * @param eName Nombre del animal que se desea obtener y eliminar
	 * @return retAnim Animal que se desea eliminar y obtener.
	 * @throws UnknownFarmAnimalException Excepcion que se lanza en caso de no encontrar al animal.
	 */
	public FarmAnimal removeFarmAnimal(FarmAnimal eFarmAnimal) throws UnknownFarmAnimalException {
		FarmAnimal retAnim=null;
		ArrayList <FarmAnimal >aux = new ArrayList <FarmAnimal>();
		for(FarmAnimal c : this.farmAnimalSet) {
			if(c.getName().equals(eFarmAnimal.getName())) {
				retAnim = c;
				this.sensorList.add(c.getMySensor());
				aux.add(c);
			}
		}
		
		this.farmAnimalSet.removeAll(aux);
		
		if(retAnim == null) throw new UnknownFarmAnimalException();
				
		return retAnim;
	
	}
	
	/**
	 * Funcion que devuelve una lista con los animales que superan una edad dada.
	 * @param eAge Edad que deben superar para ser anadidos a la lista
	 * @return ArrayList <String> Lista con los animales de la granja que superan cierta edad.
	 */
	
	public ArrayList <String> obtainFarmAnimalOlder(int eAge) {
		ArrayList <String> oldAnimal=new ArrayList<String>();
		for(FarmAnimal c : this.farmAnimalSet) {
			if(c.getAge()>eAge) {
				oldAnimal.add(c.getName());
			}
		}
		return oldAnimal;
	
	}
	
	/**
	 * Metodo que imprime por patalla los animales en la granja con sus caracteristicas.
	 */
	public void whoIsInFarm() {
		System.out.println("Animals in the farm");
		for(FarmAnimal c: this.farmAnimalSet) {

			if(c instanceof Producer) {
				System.out.println(((Producer)c).toString());
			}else{
				System.out.println(((c.getClass())).toString());
			}
		}
	}
	/**
	 * Funcion que permite conocer la cantidad que cuesta un año de granja
	 * @return double Dinero que cuesta la granja durante un año
	 */
	public double calculateAnnualCost() {
		double aux = 0;
		for(FarmAnimal c:this.farmAnimalSet) {
			aux = aux+c.calculateAnnualCost();
		}
		return aux;
	}
	
	/**
	 * Funcion que permite conocer el numero de animales ecologicos que hay en la granja.
	 * @return int Numero de animales ecologicos en la granja.
	 */
	public int farmEcologicalAccount() {
		int aux = 0;
		for(FarmAnimal c: this.farmAnimalSet) {
			if((c instanceof Ecological)&&((Ecological)c).isEcological()) {
				aux++;
			}
		}return aux;
	}
	/**
	 * Ordena el ArrayList de animales segun el identificador del sensor.
	 */
	public void sort(){
		Collections.sort(this.farmAnimalSet);
		for(FarmAnimal c: this.farmAnimalSet) {
			System.out.println(c.toString());
		}
	}
	
	
	/**
	 * Funcion que devuelve una lista con los animales que salen de la granja al 
	 * superar un cierto peso y no estar enfermos. Esta funcion recupera sus
	 * sensores y elimina a estos animales de la lista de animales de la granja.
	 * @param eWeight Peso que deben superar para salir de la granja.
	 * @param eTemp Temperatura que no deben superar para saber que no estan enfermos.
	 * @return ArrayList<FarmAnimal> Lista con los nombres de los animales que han abandonado la granja.
	 */
	public ArrayList<FarmAnimal> farmAnimalsDeparture() {
		ArrayList<FarmAnimal> retAnId = new ArrayList<FarmAnimal>();
		ArrayList <FarmAnimal> possiblySick = this.obtainPossiblySick();
		ArrayList<FarmAnimal> deleteAnim = new ArrayList<FarmAnimal>();
		for(FarmAnimal c: this.farmAnimalSet) {
			if((c.departure()) && (possiblySick.contains(c) == false)) {
				retAnId.add(c);
				deleteAnim.add(c);
				if(!(c instanceof Chicken))
				this.sensorList.add(c.getMySensor());
				}
			}
		this.farmAnimalSet.removeAll(deleteAnim);
		return retAnId;
	}
}
