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
  
  /**
   * Create gradient descent object with default settings.
   */
  public GradientDescent()
  {
    stepSize = 0.0001;
    minGradientNorm = Math.exp(-6);
    minDx = Math.exp(-6);
    maxIterations = 10000;
    objectiveFunc = new BlackBoxFunction();
  }
  /**
   * Create gradient descent object with custom settings.
   * 
   * @param stepSizeAlpha Step size alpha coefficient 
   * @param minimumGradient Minimum gradient norm stop condition
   * @param minimumDx Minimum change in x stop condition
   * @param maximumIterations Maximum iterations stop condition
   */
  public GradientDescent(double stepSizeAlpha, double minimumGradient, 
          double minimumDx, int maximumIterations)
  {
    stepSize = stepSizeAlpha;
    minGradientNorm = minimumGradient;
    minDx = minimumDx;
    maxIterations = maximumIterations;
    objectiveFunc = new BlackBoxFunction();
  }
  
  /**
   * Run gradient descent with starting value x
   * 
   * @param x Starting x value
   * @return X value of local minimum found with gradient descent
   */
  public double run(double x)
  {
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
    return x;
  }
}