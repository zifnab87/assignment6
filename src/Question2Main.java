

import gradientdescent.commons.GradientDescent;
import gradientdescent.functions.BlackBoxFunction;
import gradientdescent.functions.Function;

public class Question2Main {
	public static class Config {
		public static final Function FUNCTION = new BlackBoxFunction();
		public static final double STEP_SIZE = 0.0001;
		public static final double PRECISION = 0.00001;
		public static final int MAX_ITERATIONS = 100000;
		
		
	}
	
	public static void main(String[] args){
		
		for (int i=0; i<100;i++){
			GradientDescent GD = new GradientDescent(
					Config.FUNCTION,
					Config.STEP_SIZE,
					Config.MAX_ITERATIONS,
					Config.PRECISION
					);
			double domainMin = -20d;
			double domainMax = 20d;
			double xStart = (Math.random()-0.50)*(domainMax-domainMin);
			
			
			
			GD.setDomainMin(domainMin);
			GD.setDomainMax(domainMax);
			GD.setxStart(xStart);
			double result = GD.start();
			System.out.println(result);
		}
		
	}
}
