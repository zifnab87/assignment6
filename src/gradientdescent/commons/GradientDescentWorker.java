package gradientdescent.commons;

import gradientdescent.functions.Function;

public class GradientDescentWorker implements Runnable {
	
	/*// Minimum gradient norm stop condition
	private double minGradientNorm;
	  
	// Minmum x step stop condition
	private double minDx;
	
	// Max iterations stop condition
	private int maxIterations;
	  
	// Mystery function
	private Function objectiveFunc;
	  
	// Step size
	private double stepSize;*/
	private GradientDescent GD;
	  
	//starting point


	public GradientDescentWorker(GradientDescent GD)
	  {
		this.GD = GD;
		/*this.GD.setDomainMin(domainMin);
		this.GD.setDomainMax(domainMax);
		this.GD.setxStart(xStart);*/
		
		
		
	   /* stepSize = stepSizeAlpha;
	    minGradientNorm = minimumGradient;
	    minDx = minimumDx;
	    maxIterations = maximumIterations;
	    objectiveFunc = new BlackBoxFunction();*/
	    
	  }	
	
	  /**
	   * Run gradient descent with specified starting value 
	   *  
	   * @return X value of local minimum found with gradient descent
	   */	
		public void run() {
			
			this.GD.start();
		}
		
	
	public double getFinalValue(){
		return 0.0;
	}

}