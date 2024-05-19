package StampedLock;

import java.util.concurrent.locks.StampedLock;

public class SharedResource {
    public int a = 10;


    public void produce(StampedLock lock){

        long stamp = lock.tryOptimisticRead();
        try{
            System.out.println("Optimistic Read Lock acquired by: "+Thread.currentThread().getName());
            a=11;
            Thread.sleep(8000);

            if(lock.validate(stamp)){
                System.out.println("Value updated successfully " + a);
            }
            else{
                a = 10;
                System.out.println("Rollback of work");
            }
        }
        catch(Exception e){

        }

    }

    public void consume(StampedLock lock){
        long stamp = lock.writeLock();
        System.out.println("Write Lock acquired by: "+Thread.currentThread().getName());

        try{
            a=9;
            System.out.println("Performing some work "+a);
        }
        catch(Exception e){

        }
        finally{
            lock.unlockWrite(stamp);
            System.out.println("Unlock write lock released by: "+Thread.currentThread().getName());
        }

    }
}
