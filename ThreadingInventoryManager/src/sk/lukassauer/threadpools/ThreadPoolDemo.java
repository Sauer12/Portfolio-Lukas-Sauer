package sk.lukassauer.threadpools;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        Runnable processor = new MessageProcessor(2);
        executor.execute(processor);

        executor.shutdown();

        while(!executor.isTerminated()){

        }

    System.out.println("Submitted all tasks...  ");

    }
}
