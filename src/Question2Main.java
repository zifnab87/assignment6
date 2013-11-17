

import gradientdescent.commons.GradientDescent;
import gradientdescent.functions.BlackBoxFunction;
import gradientdescent.functions.ConvexFunction;
import gradientdescent.functions.Function;

public class Question2Main {
	public static class Config {
		public static final boolean IS_PARALLEL = false;
		public static final int NUM_WORKERS = 1;
		public static final Function FUNCTION = new BlackBoxFunction();
		public static final double STEP_SIZE = 0.001;
		public static final double PRECISION = Math.exp(-6);
		public static final int MAX_ITERATIONS = 10000;
		
		
	}
	
	public static void main(String[] args){
		
		for (int i=0; i<10000;i++){
			GradientDescent GD = new GradientDescent(
					Config.FUNCTION,
					Config.STEP_SIZE,
					Config.MAX_ITERATIONS,
					Config.PRECISION
					);
			double domainMin = Double.MIN_VALUE;
			double domainMax = Double.MAX_VALUE;
			double xStart = Math.random();
			
			
			
			GD.setDomainMin(domainMin);
			GD.setDomainMax(domainMax);
			GD.setxStart(xStart);
			double result = GD.start();
			System.out.println(result);
		}
		
	}
}
