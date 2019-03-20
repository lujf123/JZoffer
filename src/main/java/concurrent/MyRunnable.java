package concurrent;

import java.util.concurrent.*;

public class MyRunnable implements Callable<Integer> {
    @Override
    public Integer call() {  // 返回值是泛型，可以自设定
        try {
            System.out.println("ds123");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 123;
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ExecutorService executorService = Executors.newCachedThreadPool();
        FutureTask<Integer> ft = new FutureTask<>(new MyRunnable());
        executorService.execute(ft);
        //Future<?> future = executorService.submit(ft);
        //future.cancel(true);
        //System.out.println(ft.get());
        executorService.shutdown();
    }
}
