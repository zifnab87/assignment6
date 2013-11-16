package question2;

public class GradientDescent
{
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
  
  // Default constructor uses default settings
  public GradientDescent()
  {
    stepSize = 0.0001;
    minGradientNorm = 1*Math.exp(-6);
    minDx = 1*Math.exp(-6);
    maxIterations = 10000;
    objectiveFunc = new BlackBoxFunction();
  }
  
  public double run(double x)
  {
    double gradientNorm = Double.MAX_VALUE;
    double dx = Double.MAX_VALUE;
    
    // find gradient
    int iteration = 0;
    
    // gradient descent loop with 3 termination conditions
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
    return x;
  }
}