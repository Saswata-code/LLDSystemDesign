import java.util.concurrent.*;

public class Main {
    public static void main(String [] args) throws ExecutionException, InterruptedException {

        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(3,3,1,
                TimeUnit.HOURS,new ArrayBlockingQueue<>(10),Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

        CompletableFuture<String> futureObj = CompletableFuture.supplyAsync(() -> {
            return "Task Completed";
        },poolExecutor);

        // Example of thenApply
        CompletableFuture<String> asyncTask1 = CompletableFuture.supplyAsync(() -> {
            try{
                System.out.println("Current Thread is : " + Thread.currentThread().getName());
                Thread.sleep(5000);
            }
            catch(Exception e) {

            }
            return "CONCEPT";
        },poolExecutor).thenApply((String value) ->{
            System.out.println("Thread Name of then Apply : " + Thread.currentThread().getName());
            return value + "AND";
        });

        // Example of thenApply Async
        CompletableFuture<String> asyncTask2 = CompletableFuture.supplyAsync(() -> {
            try{
                System.out.println("Current Thread is : " + Thread.currentThread().getName());
                Thread.sleep(5000);
            }
            catch(Exception e) {

            }
            return "CONCEPT";
        },poolExecutor).thenApplyAsync((String value) ->{
            System.out.println("Thread Name of then Apply : " + Thread.currentThread().getName());
            return value + "AND";
        },poolExecutor);

        // Example of thenCompose
        CompletableFuture<String> asyncTask3 = CompletableFuture.supplyAsync(()-> {
            return "Saswata";
        },poolExecutor).thenCompose((String val) -> {
            return CompletableFuture.supplyAsync(() -> val + " AND");
        }).thenCompose((String value) -> {
            return CompletableFuture.supplyAsync(() -> value + " Neha");
        });

        // Example of thenComposeAsync
        CompletableFuture<String> asyncTask4 = CompletableFuture.supplyAsync(()-> {
            System.out.println("First task Thread is : " + Thread.currentThread().getName());
            return "Hello";
        },poolExecutor).thenComposeAsync((String val) -> {
            System.out.println("Second task Thread is : " + Thread.currentThread().getName());
            return CompletableFuture.supplyAsync(() -> val + " and");
        },poolExecutor).thenComposeAsync((String value) -> {
            System.out.println("Third task Thread is : " + Thread.currentThread().getName());
            return CompletableFuture.supplyAsync(() -> value + " Hi");
        },poolExecutor);

        // Example of thenAccept
        CompletableFuture<Void> asyncTask5 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Current Thread is : " + Thread.currentThread().getName());
            return "Saswata";
        },poolExecutor).thenAccept((String value) -> System.out.println(value + " has passed"));

        // Example of thenAcceptAsync
        CompletableFuture<Void> asyncTask6 = CompletableFuture.supplyAsync(()->{
            System.out.println("Current Thread in Supply Aysnc is: " + Thread.currentThread().getName());
            return "How are you ? ";
        },poolExecutor).thenAcceptAsync((String value) -> {
            System.out.println("Thread in Accept Async is: " + Thread.currentThread().getName());
            System.out.println("Answer to How are you ? I am fine");
        },poolExecutor);

        // Example of then Combine
        CompletableFuture<Integer> asyncTask7 = CompletableFuture.supplyAsync(()->{
            return 10;
        },poolExecutor);

        CompletableFuture<String> asyncTask8 = CompletableFuture.supplyAsync(()->{
            return "k";
        },poolExecutor);

        CompletableFuture<String> combinedTask = asyncTask7.thenCombine(asyncTask8,(Integer val1,String val2) -> val1 + val2);

        System.out.println(combinedTask.get());
    }
}
