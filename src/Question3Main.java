

import gradientdescent.functions.ConvexFunction;
import gradientdescent.functions.Function;

public class Question3Main {
	public static class Config {
		public static final boolean IS_PARALLEL = false;
		public static final int NUM_WORKERS = 1;
		public static final Function FUNCTION = new ConvexFunction();
		public static final double STEP_SIZE = 0.0001;
		public static final double PRECISION = 0.000001;
		public static final int MAX_ITERATIONS = 10000;
		public static final double MIN_GRADIENT_NORM = Math.exp(-6);
		
		
	}
	
	public static void main(){
		
	}
}
