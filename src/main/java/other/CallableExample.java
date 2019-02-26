package other;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableExample implements Callable<Integer> {
    public Integer call() {
        try {
            Thread.sleep(3000);
            return 12;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        CallableExample example = new CallableExample();
        FutureTask<Integer> futureTask = new FutureTask<>(example);
        Thread thread = new Thread(futureTask);
        thread.start();
        System.out.println(futureTask.get());
    }
}

