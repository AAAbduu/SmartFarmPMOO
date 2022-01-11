/**
 * 
 * Sensor es una clase que crea y manipula un objeto Sensor que registra 
 * los datos fisiologicos de los animales y cada animal tiene uno asignado.
 * 
 *   @project : @SmartFarming
 *    @author : @Abdu
 *     @date : @5/04/21
 */
package packfarm;

import java.util.Random;

import packexceptions.CollectErrorException;

public class Sensor {
	
	private String id;
	
	/**
	 * Constructora de la clase Sensor, recibe como parametro una cadena de texto
	 * que sera el identificador del Sensor.
	 * @param eId Identificador del Sensor.
	 */
	public Sensor(String eId) {
		this.id = eId;
	}
	
	/**
	 * Funcion que se encarga de recoger los posibles valores fisiologicos de un animal.
	 * @return PhysiologicalValues Valores fisiologicos registrados.
	 * @throws CollectErrorException En caso de que el Sensor del animal falle.
	 */
	
	public PhysiologicalValues collectValues(double eTemperatura) throws CollectErrorException {
		return collect(eTemperatura);
	
	}
	
	/**
	* Simulates physiological values collection with potential failure
	* @return the physiological values collected
	* @throws CollectErrorException when not possible to return the values
	*/
	private PhysiologicalValues collect(double eTemperatura) throws CollectErrorException{
	Random r= new Random();
	int heartRate= 0;
	double temperature = 0.0;
	int activity= 0;
	// Simulates the possibility or not of values capture
	heartRate = 60+ r.nextInt(20);
	temperature = eTemperatura+r.nextDouble()*2;
	temperature = Double.parseDouble(String.format("%.2f", temperature).
	replace(',', '.'));
	activity = r.nextInt(5)+1;
	PhysiologicalValues phy=
	new PhysiologicalValues(heartRate, temperature, activity);
	if (Math.random()>=0.9) throw new CollectErrorException(phy.toString());
	return phy;
	}
	
	/**
	 * Funcion que permite obtener el identificador de un Sensor.
	 * @return String Devuelve el identificador de un Sensor.
	 */
	
	@Override
	public String toString() {
		return id;
	
	}
}
