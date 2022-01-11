
/**
 * 
 * PhysiologicalValues es una clase que manipula un objeto que contiene datos 
 * fisiologicos de los animales de la granja.
 * 
 *   @project : @SmartFarming
 *    @author : @Abdu
 *     @date : @5/04/21
 */


package packfarm;


public class PhysiologicalValues {
	private int heartRate;
	private double temperature;
	private int activity;
	
	
	/**
	 * 
	 * Constructora de la clase PhyisiologicalValues, recibe como parametros 3 datos 
	 * que son los que va a almacenar.
	 * 
	 * @param eHeartRate El ritmo cardiaco que se ha registrado.
	 * @param eTemperature	La temperatura que se ha registrado.
	 * @param eActivity La actividad que se ha registrado.
	 */
	
	public PhysiologicalValues(int eHeartRate, double eTemperature, int eActivity) {
		this.heartRate = eHeartRate;
		this.temperature=eTemperature;
		this.activity = eActivity;
	}
	
	
	/**
	 * Funcion que devuelve el ritmo cardiaco.
	 * @return int Devuelve el ritmo cardiaco de un animal.
	 */
	public int getHeartRate() {
		return heartRate;
	
	}
	
	/**
	 *Funcion que devuelve la temperatura.
	 * @return double Devuelve la temperatura de un animal en grados farenheit.
	 */
	
	public double getTemperature() {
		return temperature;
	
	}
	
	/**
	 *Funcion que devuelve la actividad.
	 * @return int Devuelve la actividad realizada por un animal a lo largo del dia.
	 */
	
	public int getActivity() {
		return activity;
	
	}
	
	/**
	 *Funcion que devuelve  los valores en cadena de texto.
	 * @return String Devuelve en una cadena de texto los datos fisiologicos de un animal.
	 */
	public String toString() {
		return "HR: "+this.heartRate +" Temp: " +this.temperature+" ºF, "+ "Activity: "+this.activity;
	
	}
}
