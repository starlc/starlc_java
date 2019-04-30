/**
 *
 */
package com.starlc.thread2;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.*;

/**
 * @author starlc
 */
public class TestFutureTask {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService es = new ThreadPoolExecutor(10, 10, 60, TimeUnit.SECONDS, new LinkedBlockingDeque<>(20));
		Set<Callable<Integer>> set = new HashSet<Callable<Integer>>();
		for (int i = 0; i < 10; i++) {
			set.add(new Callable<Integer>() {

				@Override
				public Integer call() throws Exception {
					// TODO Auto-generated method stub
					return new Random().nextInt(100);
				}
			});
		}

		try {
			List<Future<Integer>> res = es.invokeAll(set);
			int count = 0;
			int recouter = 0;
			for (Future<Integer> future : res) {
				Future<Integer> tFuture = res.get(count);
				recouter += tFuture.get();
				count++;
			}
			es.shutdown();
			System.out.println(recouter);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
