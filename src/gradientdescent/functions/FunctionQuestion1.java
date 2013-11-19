package gradientdescent.functions;

public class FunctionQuestion1 extends Function{
	
	public double firstDerivative(double x)
  {
    return 108*Math.pow(x, 3)+ 111*Math.pow(x, 2) - 678*x-326;
  }
	
	public double evaluate(double x)
  {
    return 27*Math.pow(x, 4)+ 37*Math.pow(x, 3) - 339*Math.pow(x, 2)-326*x + 600;
  }
}
