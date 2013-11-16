package question2;

public class BlackBoxFunction
{
  public BlackBoxFunction()
  {
  }
  
  public double evaluate(double x)
  {
    // f(x) = (6x)*Math.expsin(sin(3*(cos(3*x))))+x^2
    return (6*x)*Math.exp(Math.sin(Math.sin(3*Math.cos(3*x))))+x*x;
  }
  
  public double grad(double x)
  {
    // d/dx ( (6x)*Math.expsin(sin(3*(cos(3*x))))+x^2 )
    return 2*x-54*x*Math.sin(3*x)*Math.cos(3*Math.cos(3*x))*
            Math.exp(Math.sin(Math.sin(3*Math.cos(3*x))))*
            Math.cos(Math.sin(3*Math.cos(3*x)))+
            6*Math.exp(Math.sin(Math.sin(3*Math.cos(3*x))));
  }
}
