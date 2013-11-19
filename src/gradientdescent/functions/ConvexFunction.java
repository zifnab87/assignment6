package gradientdescent.functions;

public class ConvexFunction extends Function {

	// y = x^5 + 27x^4 + 37x^3 - 339x^2 - 326x + 600 = (x-3)(x-1)(x+2)(x+4)(x+25)
	public double evaluate(double x)
	  {
	    return Math.pow(x, 5) + 27*Math.pow(x, 4)+
	    		37*Math.pow(x, 3) - 339*Math.pow(x, 2)-326*x + 600;
	  }
	@Override
	public double firstDerivative(double x) {
	    return 5*Math.pow(x, 4) + 108*Math.pow(x, 3)+ 111*Math.pow(x, 2) - 678*x-326;	
	    }

}
