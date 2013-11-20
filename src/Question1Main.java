import gradientdescent.commons.GradientDescent;
import gradientdescent.functions.FunctionQuestion1;
import gradientdescent.functions.Function;

public class Question1Main {
	public static class Config {
		public static final Function FUNCTION = new FunctionQuestion1();
    // TODO: Experiment with step size
		public static final double STEP_SIZE = 1;
		public static final double PRECISION = 0.001;
		public static final int MAX_STEPS = 1000;
	}
	
	public static void main(String[] args){
		GradientDescent GD = new GradientDescent(
									Config.FUNCTION,
									Config.STEP_SIZE,
									Config.MAX_STEPS,
									Config.PRECISION
							);
		double domainMin = -1*Double.MAX_VALUE;
		double domainMax = Double.MAX_VALUE;
		GD.setDomainMin(domainMin);
		GD.setDomainMax(domainMax);
    
    // TODO: Experiment with starting x location
    double xStart = 0;
		double result = GD.start(xStart);
		System.out.println(result);
	}
}
