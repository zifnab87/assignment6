import gradientdescent.commons.GradientDescent;
import gradientdescent.functions.BlackBoxFunction;
import gradientdescent.functions.Function;

public class Question2Main
{
  public static class Config
  {
    public static final Function FUNCTION = new BlackBoxFunction();
    // TODO: Experiment with step size
    public static final double STEP_SIZE = 0.0001;
    public static final double PRECISION = 0.00001;
    // TODO: Experiment with max number of steps
    public static final int MAX_STEPS = 100000;
  }

  public static void main(String[] args)
  {
    GradientDescent GD = new GradientDescent(
            Config.FUNCTION,
            Config.STEP_SIZE,
            Config.MAX_STEPS,
            Config.PRECISION);
    double domainMin = -20d;
    double domainMax = 20d;
    GD.setDomainMin(domainMin);
    GD.setDomainMax(domainMax);

    // TODO: Experiment with the number of iterations here
    double iterations = 1;
    double bestX = -1;
    double minVal = Integer.MAX_VALUE;
    Function func = Config.FUNCTION;
    for (int i = 0; i < iterations; i++)
    {
      double xStart = (Math.random() - 0.50) * (domainMax - domainMin);
      double result = GD.start(xStart);
      if (func.evaluate(result) < minVal)
      {
        bestX = result;
        minVal = func.evaluate(result);
      }
    }
    System.out.println(bestX);
  }
}
