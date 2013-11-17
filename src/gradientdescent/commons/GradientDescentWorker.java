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
	private Function func;
	private int numInternalIterations;
	
	private double finalValue;
	//starting point


	public GradientDescentWorker(GradientDescent GD,Function func, int numInternalIterations)
	  {
		this.GD = GD;
		this.func = func;
		this.numInternalIterations = numInternalIterations;
	    
	  }	
	
	  /**
	   * Run gradient descent with specified starting value 
	   *  
	   * @return X value of local minimum found with gradient descent
	   */	
		public void run() {
			
			for (int i=0; i<this.numInternalIterations; i++){
				double currentValue;
				double xStart = (Math.random()-0.50)*40;
				
				this.GD.setxStart(xStart);
				currentValue = this.GD.start();
				if(i==0 || this.func.evaluate(currentValue) <= this.func.evaluate(this.finalValue )){
					this.finalValue = currentValue;
				}
			}
		}
		
		
		
		
	
	public double getFinalValue(){
		return this.finalValue;
	}

}