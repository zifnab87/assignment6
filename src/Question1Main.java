import gradientdescent.commons.GradientDescent;
import gradientdescent.functions.ConvexFunction;
import gradientdescent.functions.Function;

public class Question1Main {
	public static class Config {
		public static final Function FUNCTION = new ConvexFunction();
		public static final double STEP_SIZE = 1;
		public static final double PRECISION = 0.001;
		public static final int MAX_ITERATIONS = 1000;
	}
	
	public static void main(String[] args){
		GradientDescent GD = new GradientDescent(
									Config.FUNCTION,
									Config.STEP_SIZE,
									Config.MAX_ITERATIONS,
									Config.PRECISION
							);
		double domainMin = -1*Double.MAX_VALUE;
		double domainMax = Double.MAX_VALUE;
		double xStart = -100d;
		
		GD.setDomainMin(domainMin);
		GD.setDomainMax(domainMax);
		GD.setxStart(xStart);
		double result = GD.start();
		System.out.println(result);
		
	}
}
