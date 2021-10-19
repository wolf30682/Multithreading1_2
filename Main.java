package Multithreading1_2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException{

        MyCallable myCallable1 = new MyCallable(5);
        MyCallable myCallable2 = new MyCallable(2);
        MyCallable myCallable3 = new MyCallable(7);
        MyCallable myCallable4 = new MyCallable(4);

        final ExecutorService threadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        final Future<Integer> future1 = threadPool.submit(myCallable1);
        final Future<Integer> future2 = threadPool.submit(myCallable2);
        final Future<Integer> future3 = threadPool.submit(myCallable3);
        final Future<Integer> future4 = threadPool.submit(myCallable4);

        final Integer resultOfTask1 = future1.get();
        System.out.println("Результат выполнения задачи 1: "+ resultOfTask1);
        final Integer resultOfTask2 = future2.get();
        System.out.println("Результат выполнения задачи 2: "+ resultOfTask2);
        final Integer resultOfTask3 = future3.get();
        System.out.println("Результат выполнения задачи 3: "+ resultOfTask3);
        final Integer resultOfTask4 = future4.get();
        System.out.println("Результат выполнения задачи 4: "+ resultOfTask4);


        System.out.println("============== Самый быстрый ===================");
        myCallable1.setCurrentCountMessages(0);
        myCallable2.setCurrentCountMessages(0);
        myCallable3.setCurrentCountMessages(0);
        myCallable4.setCurrentCountMessages(0);
        List<Callable<Integer>> callables = new ArrayList<>();
        callables.add(myCallable1);
        callables.add(myCallable2);
        callables.add(myCallable3);
        callables.add(myCallable4);
        final Integer resultAny = threadPool.invokeAny(callables);
        System.out.println("Результат выполнения самой быстрой: "+ resultAny);
    }
}
