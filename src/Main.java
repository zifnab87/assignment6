import gradientdescent.objects.Digit;

import java.util.Vector;


import static gradientdescent.utils.Utilities.filesToDigitsVector;
import static gradientdescent.utils.Utilities.countPixelOccurencies;

public class Main {
	
	
	
	
	
	public static void main(String args[]){
		byte[][] digits = null;
		// loading training data for zeros
		Vector<Digit> trainingZeros = filesToDigitsVector("digits/0-training/",12);
		// loading training data for ones
		Vector<Digit> trainingTwos = filesToDigitsVector("digits/2-training/",12);
		// loading testing data 
		//Vector<Digit> testingData = filesToDigitsVector("digits/testing/",40);
		
		//given class is 0 count the pixels that are on
		byte[][] countsForDigitZero = countPixelOccurencies(trainingZeros);
		
		//TAO can you visualize this? I guess you could see what is the max
		// and have colors between 0 and max --> convert it to 0-255 let's say
		Digit dummy = new Digit(1,countsForDigitZero);
		System.out.println(dummy); // see what is printed here (80x80)
		
		
		//given class is 2 count the pixels that are on
		byte[][] countsForDigitTwo = countPixelOccurencies(trainingTwos);
	}
}
