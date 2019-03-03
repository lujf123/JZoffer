package concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WaitNotifyExample {
    public synchronized void before() {
        System.out.println("before");
        notifyAll();
    }
    public synchronized void after() {
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("after");
    }


    public static void main(String[] args) {
        WaitNotifyExample example1 = new WaitNotifyExample();
        WaitNotifyExample example2 = new WaitNotifyExample();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> example1.after());
        executorService.execute(() -> example2.before());
    }
}
