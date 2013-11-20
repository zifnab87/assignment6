package gradientdescent.commons;

import gradientdescent.functions.Function;

public class GradientDescent
{

  // Gradient descent parameters set in constructor
  private Function function;
  private double stepSize;
  private int maxSteps;
  private double precision;
  // Default values for gradient descent domain
  private double domainMin = -Double.MAX_VALUE;
  private double domainMax = Double.MAX_VALUE;

  /**
   * Gradient Descent constructor which sets the step size, termination
   * conditions, and objective function.
   *
   * @param function Objective function
   * @param stepSize Step size scale factor at each iteration of gradient
   * descent
   * @param maxSteps Maximum number of gradient descent steps
   * @param precision Minimum size of gradient descent step
   */
  public GradientDescent(Function function, double stepSize, int maxSteps, double precision)
  {
    this.function = function;
    this.stepSize = stepSize;
    this.maxSteps = maxSteps;
    this.precision = precision;
  }

  /**
   * Runs gradient descent using GradientDescent's fields and this function's
   * starting location, xStart, argument.
   *
   * @param xStart Starting location for gradient descent
   *
   * @return Best minimum x for objective function discovered
   */
  public double start(double xStart)
  {
    double dx = Double.MAX_VALUE;
    double x = xStart;

    int stepcount = 0;

    // Gradient descent loop with 3 termination conditions
    while (stepcount < maxSteps && dx >= precision && isInDomain(x))
    {
      // Calculate gradient
      double derivative = function.firstDerivative(x);

      // Take step based on stepsize * gradient
      double xNext = x - stepSize * derivative;

      // Calculate the difference between steps
      dx = Math.abs(xNext - x);

      // Update iteration count
      stepcount++;

      // Update x for next iteration
      x = xNext;
    }
    System.out.println("steps: " + stepcount);
    return x;
  }

  public double getDomainMin()
  {
    return domainMin;
  }

  public void setDomainMin(double domainMin)
  {
    this.domainMin = domainMin;
  }

  public double getDomainMax()
  {
    return domainMax;
  }

  public void setDomainMax(double domainMax)
  {
    this.domainMax = domainMax;
  }

  //checks if an x is between domainMin and domainMax
  public boolean isInDomain(double x)
  {
    if (x >= this.domainMin && x <= this.domainMax)
    {
      return true;
    }
    else
    {
      return false;
    }
  }
}
