

import gradientdescent.commons.GradientDescent;
import gradientdescent.commons.GradientDescentWorker;
import gradientdescent.functions.BlackBoxFunction;
import gradientdescent.functions.ConvexFunction;
import gradientdescent.functions.Function;

public class Question3Main {
	public static class Config {
		public static final int NUM_WORKERS = 10;
		public static final Function FUNCTION = new BlackBoxFunction();
		public static final double STEP_SIZE = 0.0001;
		public static final double PRECISION = 0.000001;
		public static final int MAX_ITERATIONS = 10000;
		public static final double MIN_GRADIENT_NORM = Math.exp(-6);
		
		
	}
	
	public static void main(String[] args){
		
		Thread[] threads = new Thread[Config.NUM_WORKERS];
		GradientDescentWorker[] workers = new GradientDescentWorker[Config.NUM_WORKERS];
		
		for (int i=0; i<Config.NUM_WORKERS;i++){
			GradientDescent GD = new GradientDescent(
					Config.FUNCTION,
					Config.STEP_SIZE,
					Config.MAX_ITERATIONS,
					Config.PRECISION
					);
			
			double domainMin = -20d;
			double domainMax = 20d;
			
			GD.setDomainMin(domainMin);
			GD.setDomainMax(domainMax);
			int numInternalIterations = 1;
			GradientDescentWorker worker = new GradientDescentWorker(GD,Config.FUNCTION,numInternalIterations);
			workers[i] = worker;
			threads[i] = new Thread(worker);
			threads[i].start();
			
			
			
			//double result = worker.run();
			//System.out.println(result);
		}
		
		
		
		 //wait for the threads to finish
		  for(int i = 0; i < Config.NUM_WORKERS; i++){
			  try {
				threads[i].join();
			  } catch (InterruptedException e) {
				e.printStackTrace();
			  }
		  }
		  System.out.println("all threads done");
		
		  
		  
		//find the minimum of all of the threads
		  Function func = Config.FUNCTION;
		  double bestX = -1;
		  double minVal = Integer.MAX_VALUE;
		  for(int i = 0; i < Config.NUM_WORKERS; i++){
			  if(func.evaluate(workers[i].getFinalValue()) < minVal){
				  bestX = workers[i].getFinalValue();
				  minVal = func.evaluate(workers[i].getFinalValue());
			  }
		  }
		  System.out.println(bestX);
	
		
		
		
		
		
	}
}
