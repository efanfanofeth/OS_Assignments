/**
 * DiningPhilosophers.java
 *
 * This program starts the dining philosophers problem.
 *
 */


public class DiningPhilosophers
{  
   public static void main(String args[])
   {
      // Define total number of philosophers
      int totalPhilosophers = 5;
      
      Philosopher[] phils = new Philosopher[totalPhilosophers];
      DiningServerImpl server = new DiningServerImpl(totalPhilosophers);

      // Create and run threads for each philosopher
      for (int i = 0; i < totalPhilosophers; i++) {
        new Thread(new Philosopher(i, server)).start();
      }
   }
}
