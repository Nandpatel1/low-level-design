package threads.creation;

import java.util.concurrent.*;

// Implementing Callable to calculate ETA (only this task requires a return value)
//class ETACalculationTask implements Callable<String> {
//    public String call() throws InterruptedException {
//        Thread.sleep(5000);
//        System.out.println("Calculation ETA using Callable.");
//        return "ETA: 25 minutes";
//    }
//}

class ETACalculation implements Callable<String> {
    private final String location;

    ETACalculation(String location) {
        this.location = location;
    }

    public String call() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("Calculation ETA using Callable.");
        return "ETA for " + location + " : 25 minutes";
    }
}

/*
public class CallableWay {
    public static void main(String[] args) {
        // Create ExecutorService to manage threads
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        // Create Callable task for ETA calculation and Runnable tasks for SMS and Email
        SMSTask smsTask = new SMSTask();
        EmailTask emailTask = new EmailTask();
        ETACalculationTask etaTask = new ETACalculationTask();

        // Submit tasks and get Future objects for the ETA task
        Future<String> etaResult = executorService.submit(etaTask);

        // Submit the SMS and Email tasks (no result required)
        executorService.submit(smsTask);
        executorService.submit(emailTask);

        try {
            // Get the result from the Future object for ETA
            System.out.println(etaResult.get()); // Wait for ETA task to finish and print result
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        // Shutdown the ExecutorService
        executorService.shutdown();
    }
}
 */

public class CallableWay {
    public static void main(String[] args) {
        Thread smsThread = new Thread(new SMSTask());
        Thread emailThread = new Thread(new EmailTask());

        FutureTask<String> etaThreadRunnable = new FutureTask<>(new ETACalculation("Ahmedabad"));
        Thread etaThread = new Thread(etaThreadRunnable);

        System.out.println("Task Started.\n");

        // Start all threads
        smsThread.start();
        System.out.println("Task 1 ongoing...");

        emailThread.start();
        System.out.println("Task 2 ongoing...");

        etaThread.start();
        System.out.println("Task 3 ongoing...");

        // Wait for all threads to finish
        try {
            smsThread.join();
            emailThread.join();
            etaThread.join();

            String etaMessage = etaThreadRunnable.get();

            System.out.println("All tasks completed.");
            System.out.println(etaMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}