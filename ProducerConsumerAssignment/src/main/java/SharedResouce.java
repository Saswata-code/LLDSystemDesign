import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class SharedResouce {

    Queue<Integer> queue;

    int queueSize;

    public SharedResouce(int queueSize) {
        this.queue = new LinkedList<>();
        this.queueSize = queueSize;
    }

    public synchronized void produce(int item) throws InterruptedException {

        while(queue.size() == queueSize){
            System.out.println("Queue is full. Producer is waiting for consumer");
            wait();
        }

        queue.add(item);
        System.out.println("Produced: "+ item);

        // Notify the consumer that there are items to consume now.
        notify();
    }

    public synchronized int consume() throws InterruptedException {

        while(queue.size() == 0){
            System.out.println("Queue is empty. Consumer is waiting for producer to produce items");
            wait();
        }

       int item = queue.poll();
        System.out.println("Item Consumed: "+item);

        // Notify the producer that items can be produced now
        notify();
        return item;
    }
}
