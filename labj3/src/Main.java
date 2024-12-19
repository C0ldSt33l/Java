import java.util.concurrent.*;

public class Main {

    public static long fibonacci(int n) {
        if (n <= 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        int numberOfThreads = 5;
        int maxFibonacciNumber = 10;

        ExecutorService executor = Executors.newFixedThreadPool(numberOfThreads);
        CompletionService<Long> completionService = new ExecutorCompletionService<>(executor);

        for (int i = 0; i <= maxFibonacciNumber; i++) {
            final int number = i;
            completionService.submit(() -> {
                return fibonacci(number);
            });
        }

        for (int i = 0; i <= maxFibonacciNumber; i++) {
            try {
                Future<Long> future = completionService.take();
                long result = future.get();
                System.out.println("Fibonacci(" + i + ") = " + result);
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }


        executor.shutdown();
        try {
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }

        System.out.println("Все потоки завершили работу.");
    }
}
