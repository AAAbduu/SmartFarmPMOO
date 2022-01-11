package packsimulators;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Scanner;

import packfarm.Farm;
import packfarm.Sensor;

import packfarmanimal.*;

public class FarmSimulatorHierarchy {
	private static Farm farm = Farm.getFarmInstance();
	private static void loadSensors() {
		 
		try {
		      Reader archivo = new FileReader("data/availableSensors15.txt");
		      Scanner lector = new Scanner(archivo);
		      while (lector.hasNextLine()) {
		        String datoSensor = lector.nextLine();
		        Farm.getFarmInstance().addSensor(new Sensor(datoSensor));
		        System.out.println(datoSensor);
		      }
		      lector.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("No se ha encontrado el archivo.");
		      e.printStackTrace();
		    }
		System.out.println("Hay " + Farm.getFarmInstance().howManySensors()+" sensores.");
		  
	}
	
	private static void initializeFarmAnimals() {
		// 5 chickens (3 ecological and two not, 1 year old but 1 out of 4
		farm.addFarmAnimal(new Chicken("CHI34", 1, 1.5, true));
		farm.addFarmAnimal(new Chicken("CHI35", 1, 1.5, true));
		farm.addFarmAnimal(new Chicken("CHI36", 1, 1.5, true));
		farm.addFarmAnimal(new Chicken("CHI37", 4, 1.5, false));
		farm.addFarmAnimal(new Chicken("CHI38", 1, 1.5, false));

		// 2 ecological Latxa sheep and 2 non-ecological WoolSheep, about 45 kilos and 3-5 years old and one 12
		farm.addFarmAnimal(new Latxa("SHE40", 5, 45, true));
		farm.addFarmAnimal(new Latxa("SHE41", 3, 47, true));
		farm.addFarmAnimal(new WoolSheep("SHE42", 12, 45, false));
		farm.addFarmAnimal(new WoolSheep("SHE43", 4, 46, false));

		// 5 cows of about 450-600 kilos and of about 15 years (one 20), 3 ecological and 2 not
		farm.addFarmAnimal(new Cow("COW51", 20, 450, true));
		farm.addFarmAnimal(new Cow("COW52", 15, 500, true));
		farm.addFarmAnimal(new Cow("COW53", 13, 450, true));
		farm.addFarmAnimal(new Cow("COW54", 11, 550, false));
		farm.addFarmAnimal(new Cow("COW55", 10, 600, false));

		//  3 pigs with id "PIG"+n of about 80 to 200 kilos, 1 year old, two of them ecological
		farm.addFarmAnimal(new Pig("PIG70", 1, 80, false));
		farm.addFarmAnimal(new Pig("PIG71", 1, 100, true));
		farm.addFarmAnimal(new Pig("PIG72", 1, 200, true));
		// 3 horse, one of each type, with identifiers "HOR"+n, 7 years old ride and show,
		farm.addFarmAnimal(new Horse("HOR60", 10, 300, "Work"));
		farm.addFarmAnimal(new Horse("HOR61", 7, 300, "Ride"));
		farm.addFarmAnimal(new Horse("HOR62", 7, 300, "Show"));
	}

	public static void main(String[] args) {
		loadSensors();
		
		initializeFarmAnimals();
		
		
		System.out.println("Path de los animales");
		ArrayList <FarmAnimal> list= farm.getAnimalList();
		
		for(FarmAnimal c : list) {
			System.out.println( c.inheritancePath());
		}
		
		System.out.println("Primero sin ordenar, luego ordenados.");
		for(FarmAnimal c: farm.getAnimalList()) {
			System.out.println( c.toString());		
			}
		System.out.println("Ahora ordenados: ");
		farm.sort();
		System.out.println();
		
		System.out.println("Solicito 7 veces el registro de los animales");
		for (int i = 0; i<7; i++) {
			farm.register();
		}
		
		System.out.println("Posiblemente enfermos:");
		ArrayList<FarmAnimal> sickList= farm.obtainPossiblySick();
		
		for(FarmAnimal c : sickList) {
			System.out.println(c.getName());
			System.out.println( c.register().toString());
			
		}
		
		System.out.println("El gasto anual es: " + String.valueOf(farm.calculateAnnualCost()));
		
		
		System.out.println("Hay tantos animales ecologicos: " + farm.farmEcologicalAccount());
		
		System.out.println("Quedan tantos sensores: "+ farm.howManySensors());
		
		ArrayList<FarmAnimal> depList= farm.farmAnimalsDeparture();
		System.out.println("Animales que se marchan: ");
		for(FarmAnimal c : depList) {
		System.out.println(c.getName());
		}
		
		System.out.println("Quedan tantos sensores: "+ farm.howManySensors());
		
	}

}
