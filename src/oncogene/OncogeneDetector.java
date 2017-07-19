package oncogene;

import java.util.ArrayList;

public class OncogeneDetector {

	public boolean isOncogene(ArrayList<String> healthySequences, ArrayList<String> cancerSequences, String string) {
		if(healthySequences.isEmpty())
			throw new IllegalArgumentException("healthySequences must contain at least one element");
		
		if(cancerSequences.isEmpty())
			throw new IllegalArgumentException("cancerSequences must contain at least one element");
		
		if(containsInvalid(string))
			throw new IllegalArgumentException("candidate must contain only the letters A, C, G or T");
		
		for(int i = 0; i < healthySequences.size(); i++){
			if(containsInvalid(healthySequences.get(i)))
				throw new IllegalArgumentException();
		}
		
		for(int i = 0; i < cancerSequences.size(); i++){
			if(containsInvalid(cancerSequences.get(i)))
				throw new IllegalArgumentException();
		}
		
		int healthyOccurrence = 0, cancerOccurrence = 0;
		
		for(int i = 0; i < healthySequences.size(); i++){
			if(healthySequences.get(i).indexOf(string) >= 0){
				healthyOccurrence++;
			}
		}
		
		for(int i = 0; i < cancerSequences.size(); i++){
			if(cancerSequences.get(i).indexOf(string) >= 0){
				cancerOccurrence++;
			}
		}
		
		if((double) cancerOccurrence/cancerSequences.size() > (double) healthyOccurrence/healthySequences.size()){
			return true;
		} else {
			return false;
		}
	}
	
	public boolean containsInvalid(String string){
		for(int i = 0; i < string.length(); i++){
			if(!(string.substring(i,i+1).equals("A") || string.substring(i,i+1).equals("C") ||
					string.substring(i,i+1).equals("T") || string.substring(i,i+1).equals("G")))
				return true;
		}
		return false;
	}

}
