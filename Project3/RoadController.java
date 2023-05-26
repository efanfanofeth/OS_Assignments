import java.util.concurrent.Semaphore;

public class RoadController 
{

    public static void main(String[] args) 
    {
        // Creation of semaphore to use in threads and roadcontrol
        Semaphore RC = new Semaphore(1);
        // Converts the classes into new threads
        Thread eastThread1 = new Thread(new East_village(1, RC));
        Thread eastThread2 = new Thread(new East_village(2, RC));
        Thread eastThread3 = new Thread(new East_village(3, RC));
        Thread westThread1 = new Thread(new West_village(1, RC));
        Thread westThread2 = new Thread(new West_village(2, RC));
        Thread westThread3 = new Thread(new West_village(3, RC));
        // Starts all of the threads simultaneously
        eastThread1.start();
        eastThread2.start();
        eastThread3.start();
        westThread1.start();
        westThread2.start();
        westThread3.start();
    }
}