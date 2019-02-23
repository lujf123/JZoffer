package concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountdownLatchExample implements Runnable {
    private CountDownLatch countDownLatch;
    CountdownLatchExample (int totalThread) {
        this.countDownLatch = new CountDownLatch(totalThread);
    }
    public void run() {
        System.out.println("run..");
        countDownLatch.countDown();
    }

    public static void main(String[] args) throws InterruptedException {
        final int totalThread = 10;
        CountdownLatchExample example = new CountdownLatchExample(totalThread);

        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < totalThread; i++) {
            executorService.execute(example);
        }
        example.countDownLatch.await();
        System.out.println("end");
        executorService.shutdown();
    }
}
