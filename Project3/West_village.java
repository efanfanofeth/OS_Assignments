import java.util.concurrent.Semaphore;

public class West_village implements Runnable
{
   // creates the variable for the villager, semaphore control, and tasks the villagers perform while traveling
   private int villager_number;
   private Semaphore roadController;
   private String[] task = {" Drinking wine", " Playing Cards", " Reading JJK", " Eating Donuts"};

   public West_village(int vill, Semaphore RoadControl)
   {
      // places private variables into the class
      this.villager_number = vill;
      this.roadController = RoadControl;
   }
   public void run()
   {
      //synchronized use
      synchronized (roadController) 
      {
         try
         {
         // semaphore use, only plays when a semaphore is available
         roadController.acquire();
         // villager travel, task, and finishing exchange
         System.out.println("West_villager_" + villager_number + " is traveling on the road.");
         System.out.println("West_villager_" + villager_number + " is" + task[(int) (Math.random()*task.length)]);
         System.out.println("West_villager_" + villager_number + " Has Finished the exchange.");
         // sleeping for random period of time
         Thread.sleep((long) (Math.random() * 3000));
         // gives away semaphore for another thread to use
         roadController.release();
         }
         // catches any exception errors that may occur
         catch (InterruptedException ioe) 
         {
            ioe.printStackTrace();
         }
      }  
   }
}
