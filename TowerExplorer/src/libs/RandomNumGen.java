package libs;

import java.util.Random;


public final class RandomNumGen {
  
    /** Generate a random integers in the range 1 to 4. */
  public static int d4(int numberOfDice){
      Random randomGenerator = new Random();
      int randomInt = 0;
      int calculatedInt = 0;
      
      for (int i = 0; i < numberOfDice; i++){
          
      randomInt = randomGenerator.nextInt(4) + 1;
      
      calculatedInt += randomInt;
      }
      
      return calculatedInt;
      
  }
  
  /** Generate a random integers in the range 1 to 6. */ 
  public static int d6(int numberOfDice){
      Random randomGenerator = new Random();
      int randomInt = 0;
      int calculatedInt = 0;
      
      for (int i = 0; i < numberOfDice; i++){
          
      randomInt = randomGenerator.nextInt(6) + 1;
      
      calculatedInt = 0;
      }
      
      return calculatedInt;
      
  }
 
  /** Generate a random integers in the range 1 to 8. */
  public static int d8(int numberOfDice){
      Random randomGenerator = new Random();
      int randomInt = 0;
      int calculatedInt = 0;
      
      for (int i = 0; i < numberOfDice; i++){
          
      randomInt = randomGenerator.nextInt(8) + 1;
      
      calculatedInt += randomInt;
      }
      
      return calculatedInt;
      
  }
  
  /** Generate a random integers in the range 1 to 10. */
  public static int d10(int numberOfDice){
      Random randomGenerator = new Random();
      int randomInt = 0;
      int calculatedInt = 0;
      
      for (int i = 0; i < numberOfDice; i++){
          
      randomInt = randomGenerator.nextInt(10) + 1;
      
      calculatedInt += randomInt;
      }
      
      return calculatedInt;
      
  }
  
  /** Generate a random integers in the range 1 to 12. */
  public static int d12(int numberOfDice){
      Random randomGenerator = new Random();
      int randomInt = 0;
      int calculatedInt = 0;
      
      for (int i = 0; i < numberOfDice; i++){
          
      randomInt = randomGenerator.nextInt(12) + 1;
      
      calculatedInt += randomInt;
      }
      
      return calculatedInt;
      
  }
 
  /** Generate a random integers in the range 1 to 20. */
  public static int d20(int numberOfDice){
      Random randomGenerator = new Random();
      int randomInt = 0;
      int calculatedInt = 0;
      
      for (int i = 0; i < numberOfDice; i++){
          
      randomInt = randomGenerator.nextInt(20) + 1;
      
      calculatedInt += randomInt;
      }
      
      return calculatedInt;
      
  }
  
  /** Generate a random integers in the range 1 to 100. */
  public static int d100(int numberOfDice){
      Random randomGenerator = new Random();
      int randomInt = 0;
      int calculatedInt = 0;
      
      for (int i = 0; i < numberOfDice; i++){
          
      randomInt = randomGenerator.nextInt(100) + 1;
      
      calculatedInt += randomInt;
      }
      
      return calculatedInt;
      
  }
}