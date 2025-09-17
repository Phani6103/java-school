public class Concurrency {
    // --- 1. Using java.util.concurrent.ExecutorService and Future ---
    // ExecutorService is a higher-level replacement for working with threads directly.
    // It manages a pool of worker threads and submits tasks to it.
    // Future represents the result of an asynchronous computation.

    static class CallableTask implements java.util.concurrent.Callable<String> {
        private String taskName;
        private long sleepTime;

        public CallableTask(String taskName, long sleepTime) {
            this.taskName = taskName;
            this.sleepTime = sleepTime;
        }

        @Override
        public String call() throws Exception {
            System.out.println(taskName + " started.");
            Thread.sleep(sleepTime); // Simulate work
            System.out.println(taskName + " finished.");
            return "Result from " + taskName;
        }
    }

    // --- 2. Using java.util.concurrent.locks.ReentrantLock for explicit locking ---
    // ReentrantLock provides more fine-grained control over locking than synchronized methods/blocks.
    // It allows for features like timed lock attempts, interruptible lock acquisition, and fairness.

    static class SharedResourceWithLock {
        private int counter = 0;
        private final java.util.concurrent.locks.ReentrantLock lock = new java.util.concurrent.locks.ReentrantLock();

        public void increment() {
            lock.lock(); // Acquire the lock
            try {
                // Critical section
                counter++;
                System.out.println(Thread.currentThread().getName() + " incremented counter to: " + counter);
            } finally {
                lock.unlock(); // Release the lock in a finally block to ensure it's always released
            }
        }

        public int getCounter() {
            return counter;
        }
    }

    // --- 3. Using java.util.concurrent.Semaphore for controlling access to a limited number of resources ---
    // A semaphore maintains a set of permits. acquire() blocks if no permit is available.
    // release() adds a permit.

    static class PrinterQueue {
        private final java.util.concurrent.Semaphore semaphore;

        public PrinterQueue(int maxPrinters) {
            this.semaphore = new java.util.concurrent.Semaphore(maxPrinters);
        }

        public void printDocument(String documentName) {
            try {
                semaphore.acquire(); // Wait for a permit
                System.out.println("Printing document: " + documentName);
                Thread.sleep(2000); // Simulate printing
                System.out.println("Finished printing document: " + documentName);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release(); // Release the permit
            }
        }
    }

    // --- 4. Using the volatile keyword for visibility ---
    // The volatile keyword ensures that changes to a variable are always visible to other threads.
    // It guarantees that any thread that reads the field will see the most recent value written to it.
    // It does NOT provide atomicity for compound actions (like incrementing).

    static class Worker implements Runnable {
        // Without volatile, the change to 'running' might not be visible to the worker thread,
        // potentially causing an infinite loop on some systems.
        private volatile boolean running = true;

        public void stop() {
            running = false;
            System.out.println("Stop signal sent to worker.");
        }

        @Override
        public void run() {
            while (running) {
                // Simulate some work
                System.out.println("Worker is running...");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt(); // Restore the interrupted status
                }
            }
            System.out.println("Worker has stopped.");
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Demonstrating ExecutorService and Future ---");
        java.util.concurrent.ExecutorService executorService = java.util.concurrent.Executors.newFixedThreadPool(2);
        java.util.concurrent.Future<String> futureTask1 = executorService.submit(new CallableTask("Task 1", 3000));
        java.util.concurrent.Future<String> futureTask2 = executorService.submit(new CallableTask("Task 2", 2000));
        try {
            System.out.println("Result from Task 1: " + futureTask1.get());
            System.out.println("Result from Task 2: " + futureTask2.get());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }

        System.out.println("\n--- Demonstrating Explicit Locking ---");
        SharedResourceWithLock sharedResource = new SharedResourceWithLock();
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                sharedResource.increment();
            }
        }, "Thread 1");
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                sharedResource.increment();
            }
        }, "Thread 2");

        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final counter value: " + sharedResource.getCounter());

        System.out.println("\n--- Demonstrating Semaphore for Controlling Access to Resources ---");
        PrinterQueue printerQueue = new PrinterQueue(2);    
        new Thread(() -> printerQueue.printDocument("Document 1")).start();
        new Thread(() -> printerQueue.printDocument("Document 2")).start();
        new Thread(() -> printerQueue.printDocument("Document 3")).start();
        new Thread(() -> printerQueue.printDocument("Document 4")).start();

        // Allow semaphore demo to run for a bit before the next section
        try { Thread.sleep(5000); } catch (InterruptedException e) { e.printStackTrace(); }

        System.out.println("\n--- Demonstrating the volatile keyword for visibility ---");
        Worker worker = new Worker();
        Thread workerThread = new Thread(worker);
        workerThread.start();

        try {
            // Let the worker run for a bit
            Thread.sleep(2100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Signal the worker to stop from the main thread
        worker.stop();
        try { workerThread.join(); } catch (InterruptedException e) { e.printStackTrace(); }
        System.out.println("Main thread confirms worker has finished.");
    }

}
