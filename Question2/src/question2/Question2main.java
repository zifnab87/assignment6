package question2;

public class Question2main
{

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args)
  {
    GradientDescent gd = new GradientDescent(0.0001,
            Math.exp(-6), Math.exp(-6), 10000);
    System.out.println(gd.run(-2.5));
  }
}
