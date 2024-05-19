package StampedLock;

import StampedLock.SharedResource;

import java.util.concurrent.locks.StampedLock;

public class Main {
    public static void main(String[] args){

        SharedResource resource = new SharedResource();
        StampedLock lock = new StampedLock();

        Thread thread1 = new Thread(()-> {
            resource.produce(lock);
        });

        Thread thread2 = new Thread(() -> {
            resource.consume(lock);
        });

        thread1.start();
        thread2.start();

    }
}
