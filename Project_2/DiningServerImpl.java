/**
 * DiningServer.java
 *
 * This class contains the methods called by the  philosophers.
 *
 */

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class DiningServerImpl  implements DiningServer
{  
	private int totPhils;		// total number of all philosophers
	private int[] statusInts;	// 0: thinking, 1: hungry, 2: eating
	private Condition[] self;	// Condition variable for each philosopher
	private Lock lock;			// Lock variable

	// Contructor
	public DiningServerImpl(int totalNumberOfPhils) {
		totPhils = totalNumberOfPhils;
		statusInts = new int[totalNumberOfPhils];
		self = new Condition[totalNumberOfPhils];
		lock = new ReentrantLock();
		
		for (int i = 0; i < totalNumberOfPhils; i ++) {
			statusInts[i] = 0;
			self[i] = lock.newCondition();
		}
	}

	// called by a philosopher when they wish to eat
	public void takeForks(int philNumber) {
		lock.lock();
		try {
			statusInts[philNumber] = 1;
			testPhil(philNumber);
			if (statusInts[philNumber] != 2)
				self[philNumber].await();
		}
		catch (InterruptedException exception) {
			System.err.println("Exception error occurred !!!");;
			exception.printStackTrace();
		}
		finally {
			lock.unlock(); // In any cases, lock must be unlocked after processing.
		}
	}

	// called by a philosopher when they are finished eating
	public void returnForks(int philNumber) {
		lock.lock();
		try {
			// Change my status
			statusInts[philNumber] = 0;
			// Check left philosopher
			testPhil(getLeftSideNumber(philNumber));
			// Check right philosoper
			testPhil(getRightSideNumber(philNumber));
		}
		finally {
			lock.unlock();
		}
	}

	// Check the given number of the philosopher and if possible, make her eat
	private void testPhil(int philNumber) {
		// If I am hugry and left person is not eating and right person is not eating at the same time,
		// make my status eating
		if (statusInts[philNumber] == 1
			&& statusInts[getLeftSideNumber(philNumber)] != 2
			&& statusInts[getRightSideNumber(philNumber)] != 2) {
				statusInts[philNumber] = 2;
				self[philNumber].signal();
			}
	}

	// Get id number of the philosopher on the left side of the given philosopher
	private int getLeftSideNumber(int philNumber) {
		return (philNumber + totPhils - 1) % totPhils;
	}

	// Get id number of the philosopher on the right side of the given philosopher
	private int getRightSideNumber(int philNumber) {
		return (philNumber + 1) % totPhils;
	}
}
