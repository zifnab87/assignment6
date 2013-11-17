package gradientdescent.functions;

public class ConvexFunction extends Function {

	
	public double evaluate(double x)
	  {
	    return x*x;
	  }
	@Override
	public double firstDerivative(double x) {
		return 2*x;
	}

}
