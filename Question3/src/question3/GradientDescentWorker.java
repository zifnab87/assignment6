package question3;

public class GradientDescentWorker implements Runnable {
	
	// Minimum gradient norm stop condition
	private double minGradientNorm;
	  
	// Minmum x step stop condition
	private double minDx;
	
	// Max iterations stop condition
	private int maxIterations;
	  
	// Mystery function
	private BlackBoxFunction objectiveFunc;
	  
	// Step size
	private double stepSize;
	  
	//starting point
	private double x;

	public GradientDescentWorker( double stepSizeAlpha, double minimumGradient, 
	          double minimumDx, int maximumIterations, double xStart)
	  {
	    stepSize = stepSizeAlpha;
	    minGradientNorm = minimumGradient;
	    minDx = minimumDx;
	    maxIterations = maximumIterations;
	    objectiveFunc = new BlackBoxFunction();
	    x = xStart;
	  }	
	
	  /**
	   * Run gradient descent with specified starting value 
	   *  
	   * @return X value of local minimum found with gradient descent
	   */	
		public void run() {
			
			double gradientNorm = Double.MAX_VALUE;
		    double dx = Double.MAX_VALUE;
	
		    int iteration = 0;
	
		    // Gradient descent loop with 3 termination conditions
		    while (iteration < maxIterations && 
		            gradientNorm >= minGradientNorm &&
		            dx >= minDx)
		    {
		      // Calculate gradient
		      double gradient = objectiveFunc.grad(x);
		      
		      // Calculate gradient norm
		      gradientNorm = Math.sqrt(gradient * gradient);
		      
		      // Take step based on stepsize * gradient
		      double xNext = x - stepSize * gradient;
		      
		      // Update termination condition with norm of xNext - x
		      dx = Math.sqrt((xNext-x)*(xNext-x));
		      
		      // Update iteration count
		      iteration++;
		      
		      // Update x for next iteration
		      x = xNext;
		    }
		    System.out.println("iterations: " + iteration);
		}
		
	
	public double getFinalValue(){
		return x;
	}

}
