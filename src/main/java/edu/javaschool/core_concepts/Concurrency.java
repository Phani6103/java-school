package edu.javaschool.core_concepts;

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

    // --- 5. Using wait(), notify(), and notifyAll() for Inter-thread Communication ---
    // These methods, part of the Object class, are the fundamental mechanism for making threads cooperate.
    // They must be called from within a synchronized block on the object being used as a lock.
    // - wait(): Causes the current thread to release the lock and go into a waiting state.
    // - notify(): Wakes up a single thread that is waiting on this object's monitor.
    // - notifyAll(): Wakes up all threads waiting on this object's monitor. It's generally safer to use notifyAll().

    static class MessageBroker {
        private final java.util.Queue<String> queue = new java.util.LinkedList<>();
        private final int capacity;

        public MessageBroker(int capacity) {
            this.capacity = capacity;
        }

        public synchronized void produce(String message) throws InterruptedException {
            // Use a while loop to protect against "spurious wakeups"
            while (queue.size() == capacity) {
                System.out.println(Thread.currentThread().getName() + ": Queue is full, waiting to produce...");
                wait(); // Releases the lock and waits for a signal
            }

            queue.add(message);
            System.out.println(Thread.currentThread().getName() + ": Produced message '" + message + "'");
            // Notifies all waiting threads (consumers in this case) that the state has changed.
            notifyAll(); // notifyAll() is generally safer as it wakes all threads.
            // Using notify() wakes only one arbitrary thread. It's more efficient but riskier.
            // notify();
        }

        public synchronized String consume() throws InterruptedException {
            while (queue.isEmpty()) {
                System.out.println(Thread.currentThread().getName() + ": Queue is empty, waiting to consume...");
                wait(); // Releases the lock and waits for a signal
            }

            String message = queue.poll();
            System.out.println(Thread.currentThread().getName() + ": Consumed message '" + message + "'");
            // Notifies all waiting threads (producers in this case) that the state has changed.
            // notifyAll();
            // Using notify() here. In a simple producer/consumer scenario, it works, but it's fragile.
            notify();
            return message;
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

        System.out.println("\n--- Demonstrating wait(), notify(), and notifyAll() ---");
        MessageBroker messageBroker = new MessageBroker(2); // A small capacity to see waiting

        // Producer thread
        Thread producer = new Thread(() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    messageBroker.produce("Message " + i);
                    Thread.sleep(500); // Produce slowly
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }, "Producer");

        // Consumer thread
        Thread consumer = new Thread(() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    messageBroker.consume();
                    Thread.sleep(5000); // Consume slowly
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }, "Consumer");

        producer.start();
        consumer.start();

        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Producer-Consumer demo finished.");
    }

}
