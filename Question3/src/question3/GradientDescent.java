package question3;


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
	  
	  //Number of threads
	  private int numThreads;
	  
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
	    numThreads = 1;
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
	          double minimumDx, int maximumIterations, int nThreads)
	  {
	    stepSize = stepSizeAlpha;
	    minGradientNorm = minimumGradient;
	    minDx = minimumDx;
	    maxIterations = maximumIterations;
	    objectiveFunc = new BlackBoxFunction();
	    numThreads = nThreads;
	    
	    
	  }
	  
	  /**
	   * Run gradient descent in a multithreaded way based on inputs to constructor
	   *  
	   * 
	   * @return best minimum found with gradient descent
	   */	
	  public double runMultiThreadedGD()
	  {
		  
		  //create threads and workers
		  //this is kind of wasteful right now - maybe the worker should 
		  //extend Thread instead of implementing Runnable
		  Thread[] threads = new Thread[numThreads];
		  GradientDescentWorker[] workers = new GradientDescentWorker[numThreads];
		  for(int i = 0; i < numThreads; i++){
			  //this will vary form -20 to 20
			  double start = (Math.random()-0.5)*40;
			  GradientDescentWorker worker = new GradientDescentWorker(stepSize, minGradientNorm, 
			          minDx, maxIterations, start);
			  workers[i] = worker;
			  threads[i] = new Thread(worker);
			  threads[i].start();
		  }
		  
		  //wait for the threads to finish
		  for(int i = 0; i < numThreads; i++){
			  try {
				threads[i].join();
			  } catch (InterruptedException e) {
				e.printStackTrace();
			  }
		  }
		  System.out.println("all threads done");
		  
		  //fidn the minimum of all of the threads
		  BlackBoxFunction func = new BlackBoxFunction();
		  double bestX = -1;
		  double minVal = Integer.MAX_VALUE;
		  for(int i = 0; i < numThreads; i++){
			  if(func.evaluate(workers[i].getFinalValue()) < minVal){
				  bestX = workers[i].getFinalValue();
				  minVal = func.evaluate(workers[i].getFinalValue());
			  }
		  }
		  return bestX;
	  }
}

