package sk.lukassauer.concurrencyUtils;

import sk.lukassauer.concurrencyUtils.Consumer;
import sk.lukassauer.concurrencyUtils.Producer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Application {
    public static void main(String[] args) {
        BlockingQueue<Integer> questionQueue = new ArrayBlockingQueue<Integer>(5);

        Thread t1 = new Thread(new Producer(questionQueue));
        Thread t2 = new Thread(new Consumer(questionQueue));

        t1.start();
        t2.start();
    }
}
