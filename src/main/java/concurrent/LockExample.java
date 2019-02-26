package concurrent;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockExample {

    private Lock lock = new ReentrantLock();

    public void func1() {
        lock.lock();
        try {
            Thread.sleep(2000);
            for (int i = 0; i < 10; i++) {
                System.out.print(i + " ");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock(); // 确保释放锁，从而避免发生死锁。
        }
    }

    public void func2() {
        for (int i = 0; i < 10; i++) {
            System.out.print("func2");
        }
    }

    public static void main(String[] args) {
        LockExample example = new LockExample();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> example.func1());
        executorService.execute(() -> example.func2());
    }
}


