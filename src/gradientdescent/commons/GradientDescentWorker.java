package gradientdescent.commons;

import gradientdescent.functions.Function;

public class GradientDescentWorker implements Runnable
{

  // Gradient descent algorithm object
  private GradientDescent GD;
  // Current objective function
  private Function func;
  // Number of worker iterations with random starting location in domain
  private int numInternalIterations;
  // Best minimum result discovered by this worker
  private double finalValue;

  public GradientDescentWorker(GradientDescent GD, Function func, int numInternalIterations)
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
  public void run()
  {

    for (int i = 0; i < this.numInternalIterations; i++)
    {
      double currentValue;
      double xStart = (Math.random() - 0.50) * 40;

      currentValue = this.GD.start(xStart);
      if (i == 0 || this.func.evaluate(currentValue) <= this.func.evaluate(this.finalValue))
      {
        this.finalValue = currentValue;
      }
    }
  }

  public double getFinalValue()
  {
    return this.finalValue;
  }
}