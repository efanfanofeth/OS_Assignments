/**
 * Philosopher.java
 *
 * This class represents each philosopher thread.
 * Philosophers alternate between eating and thinking.
 *
 */


public class Philosopher implements Runnable
{

	private int philNumber;
	private DiningServerImpl server;

	// Constructor
	public Philosopher(int philNumber, DiningServerImpl server) {
		this.philNumber = philNumber;
		this.server = server;
	}

	@Override
	public void run() {
		// think and eat with a random time period infinitely
		while (true) {
			think();
			server.takeForks(philNumber);
			eat();
			server.returnForks(philNumber);
		}
	}

	// Show thinking status and wait a random time period between 1 and 3 seconds
	private void think() {
		try {
			System.out.println("Phil # " + philNumber + " is thinking......");
			Thread.sleep((long)(Math.random()*2000 + 1000));
		}
		catch (InterruptedException exception) {
			System.err.println("Exception error occurred !!!");
			exception.printStackTrace();
		}
	}

	// Show eating status and wait a random time period between 1 and 3 seconds
	private void eat() {
		try {
			System.out.println("Phil # " + philNumber + " is eating !!!");
			Thread.sleep((long) (Math.random() * 2000 + 1000));
		}
		catch (InterruptedException exception) {
			System.err.println("Exception error occurred !!!");
			exception.printStackTrace();
		}
	}


}
