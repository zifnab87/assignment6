package gradientdescent.commons;

import gradientdescent.functions.Function;

public class GradientDescent {
	
	private Function function;
	private double stepSize;
	private int numOfIterations; 
	private double precision;
	
	private double domainMin;
	private double domainMax;
	
	private double xStart;
	
	public GradientDescent(Function function, double stepSize, int numOfIterations, double precision){
		this.function = function;
		this.stepSize = stepSize;
		this.numOfIterations = numOfIterations;
		this.precision = precision;
		
	}

	
	public double start(){
	    double dx = Double.MAX_VALUE;
	    double x = this.xStart;

	    int iteration = 0;

	    // Gradient descent loop with 3 termination conditions
	    while (iteration < numOfIterations && dx >= precision)
	    {
	      // Calculate gradient
	      double gradient = function.firstDerivative(x);
	      
	      // Take step based on stepsize * gradient
	      double xNext = x - stepSize * gradient;
	      
	      // Calculate the difference between steps
	      dx = Math.abs(xNext-x);
	      
	      // Update iteration count
	      iteration++;
	      
	      // Update x for next iteration
	      x = xNext;
	    }
	    //System.out.println("iterations: " + iteration);
	    return x;
	}
	
	public double getxStart() {
		return xStart;
	}

	public void setxStart(double xStart) {
		this.xStart = xStart;
	}
	
	public double getDomainMin() {
		return domainMin;
	}

	public void setDomainMin(double domainMin) {
		this.domainMin = domainMin;
	}

	public double getDomainMax() {
		return domainMax;
	}

	public void setDomainMax(double domainMax) {
		this.domainMax = domainMax;
	}

	public GradientDescent(double domainMin, double domanMax){
		this.domainMin = domainMin;
		this.domainMax = domainMax;
	}
	
	//checks if an x is between domainMin and domainMax
	public boolean isInDomain(double x){
		if (x>=this.domainMin && x<=this.domainMax){
			return true;
		}
		else {
			return false;
		}
	}
}
