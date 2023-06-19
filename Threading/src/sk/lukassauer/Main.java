package sk.lukassauer;

// Press ⇧ twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static void main(String[] args) {

        Task taskRunner = new Task("Thread A");
        taskRunner.start();

        System.out.println("Hello threading world!");

        Task taskRunner2 = new Task("Thread B");
        taskRunner2.start();

        System.out.println("Runable interface thread");
        TaskRunable taskRunner3 = new TaskRunable("Thread A(runable)");
        Thread t1 = new Thread(taskRunner3);
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread4");
            }
        });
        t2.start();
    }
}

class Task extends Thread {

    private String threadName;
    public Task(String threadName){
        this.threadName = threadName;
    }

    public void run() {
        Thread.currentThread().setName(threadName);
        for(int i = 0; i < 1000; i++) {
            System.out.println("number: " + i + " - " + Thread.currentThread().getName());
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

class TaskRunable implements Runnable{
    private String threadName;
    public TaskRunable(String threadName){
        this.threadName = threadName;
    }

    public void run(){
        Thread.currentThread().setName(threadName);
        for(int i = 0; i < 1000; i++) {
            System.out.println("number: " + i + " - " + Thread.currentThread().getName());
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}
