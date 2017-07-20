package animal_hipster;

import java.util.ArrayList;
import java.util.HashMap;

public class AnimalHipster {

	public ArrayList<String> findAnimalHipsters(HashMap<String, ArrayList<String>> network,
												HashMap<String, String> favoriteAnimals) {
		
		ArrayList<String> hipsters = new ArrayList<String>();
		Object[] personsObject = network.keySet().toArray();
		String[] persons = new String[personsObject.length];
		
		for(int i = 0; i < personsObject.length; i++)
			persons[i] = (String) personsObject[i];
		
		boolean hipster;
		
		for(int i = 0; i < network.size(); i++){
			hipster = true;
			
			for(int j = 0; j < network.get(persons[i]).size(); j++){
				if(favoriteAnimals.get(persons[i]).equals(favoriteAnimals.get(network.get(persons[i]).get(j))))
					hipster = false;
			}
			
			if(hipster)
				hipsters.add(persons[i]);
		}
		
		return hipsters;
	}

}
