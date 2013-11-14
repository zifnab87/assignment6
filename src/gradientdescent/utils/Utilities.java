package gradientdescent.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;
import gradientdescent.objects.Digit;

import static gradientdescent.objects.Config.HEIGHT;
import static gradientdescent.objects.Config.WIDTH;

public class Utilities {
	//input: a directory that contains png files from 1...NumOfFiles
	//returns a vector with Digit objects that each of them contains an id and the pixel data
	
	public static Vector<Digit> filesToDigitsVector(String directoryPath, int NumOfFiles){
		Vector<Digit> digits = new Vector<Digit>();
		for(int i=1; i<=NumOfFiles; i++){
			try {
				byte[][] pixels = getPixelArray(directoryPath+i+".png");
				digits.add(new Digit(i,pixels));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return digits;
	}
	
	// it returns an array that is height by width and has zeros and ones that correspond
		// to the pixels of the handwritten digit image path passed:
		// if pixel is white then zero is returned (off)
		// if pixel is any other color (e.g black) one is returned in that position
		// (j,i) position: j-th line and i-th row 
	
	public static byte[][] getPixelArray(String imagePath) throws IOException{
		BufferedImage bufImage = javax.imageio.ImageIO.read(new File(imagePath));
		int width = bufImage.getWidth();
		int height = bufImage.getHeight();
		byte[][] pixels = new byte[height][width];
		for (int j=0; j<height; j++){
			for (int i=0; i<width; i++){
				int val = bufImage.getRGB(i,j);
				int a = (0xff000000 & val) >>> 24;
				int r = (0x00ff0000 & val) >> 16;
				int g = (0x0000ff00 & val) >> 8;
				int b = (0x000000ff & val);
				if (r == 255 && b == 255 && g == 255){
					pixels[j][i] = 0;
				}
				else {
					pixels[j][i] = 1;
				}
			}
		}
		return pixels;
	}
	
	
	
	
	//fill the body of this function so that given a collection of digits
	//it counts in each of the positions how many pixels were on or off
	public static byte[][] countPixelOccurencies(Vector<Digit> digits){
		
		byte[][] counts = new byte[HEIGHT][WIDTH];
		//THEY HAVE TO IMPLEMENT FROM HERE:
		for (Digit digit : digits){
			for (int j=0; j<HEIGHT; j++){
				for (int i=0; i<WIDTH; i++){
					if (digit.digits[j][i]==1){
						counts[j][i]++;
					}
				}
			}
		}
		
		
		return counts;
	}
	
	
}
