package gradientdescent.commons;

import gradientdescent.functions.BlackBoxFunction;
import gradientdescent.functions.ConvexFunction;

public class Config {
	public static boolean IS_PARALLEL = false;
	public static int NUM_WORKERS = 1;
	public static Class FUNCTION = BlackBoxFunction.class;
	//public static Class FUNCTION = ConvexFunction.class;
	public static double STEP_SIZE = 0.0001;
	public static double PRECISION = 0.000001;
	public static double MAX_ITERATIONS = 10000;
	
}
