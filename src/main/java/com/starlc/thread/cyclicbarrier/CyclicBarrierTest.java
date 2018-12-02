/**
 * 
 */
package com.starlc.thread.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author starlc
 *
 */
public class CyclicBarrierTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Solver {
	final int N;
	final float[][] data;
	final CyclicBarrier barrier;

	class Worker implements Runnable {
		int myRow;

		Worker(int row) {
			myRow = row;
		}

		public void run() {
			while (!done()) {
				processRow(myRow);

				try {
					barrier.await();
				} catch (InterruptedException ex) {
					return;
				} catch (BrokenBarrierException ex) {
					return;
				}
			}
		}
		
		boolean done(){
			return true;
		}
		void processRow(int row){
			
		}
	}

	public Solver(float[][] matrix) {
	     data = matrix;
	     N = matrix.length;
	     barrier = new CyclicBarrier(N, 
	                                 new Runnable() {
	                                   public void run() { 
	                                     mergeRows(); 
	                                   }
	                                 });
	     for (int i = 0; i < N; ++i) 
	       new Thread(new Worker(i)).start();

	     waitUntilDone();
	   }
	
	void waitUntilDone(){}
	void mergeRows(){}
}
