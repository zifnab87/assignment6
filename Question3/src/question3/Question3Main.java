package question3;

public class Question3Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	    GradientDescent gd = new GradientDescent(0.0001,
	            Math.exp(-6), Math.exp(-6), 10000, 5);
	    System.out.println("final answer: " + gd.runMultiThreadedGD());
	}

}
