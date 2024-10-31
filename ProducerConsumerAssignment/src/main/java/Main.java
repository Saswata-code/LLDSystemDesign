public class Main {

    public static void main(String[] args){

        SharedResouce sharedResouce = new SharedResouce(3);

        Thread producerThread = new Thread(() -> {
            for(int i=1;i<=6;i++){
                try {
                    sharedResouce.produce(i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread consumerThread = new Thread(() -> {
            for(int i=1;i<=6;i++){
                try {
                    sharedResouce.consume();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        producerThread.start();
        consumerThread.start();

    }
}
