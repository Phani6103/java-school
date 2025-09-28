package edu.javaschool.core_concepts;

public class Multithreading {
    // --- 1. Extending the Thread class ---
    static class MyThread extends Thread {
        private String threadName;

        public MyThread(String name) {
            this.threadName = name;
            System.out.println("Creating " + threadName);
        }

        @Override
        public void run() {
            System.out.println("Running " + threadName);
            try {
                for (int i = 4; i > 0; i--) {
                    System.out.println("Thread: " + threadName + ", " + i);
                    // Let the thread sleep for a while.
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                System.out.println("Thread " + threadName + " interrupted.");
            }
            System.out.println("Thread " + threadName + " exiting.");
        }
    }

    // --- 2. Implementing the Runnable interface ---
    static class MyRunnable implements Runnable {
        private String threadName;

        public MyRunnable(String name) {
            this.threadName = name;
            System.out.println("Creating " + threadName);
        }

        @Override
        public void run() {
            System.out.println("Running " + threadName);
            try {
                for (int i = 4; i > 0; i--) {
                    System.out.println("Runnable: " + threadName + ", " + i);
                    Thread.sleep(2000);
                }
            } catch (InterruptedException e) {
                System.out.println("Runnable " + threadName + " interrupted.");
            }
            System.out.println("Runnable " + threadName + " exiting.");
        }
    }

    // --- 3. Thread Synchronization Example ---
    static class Counter {
        private int count = 0;

        // Synchronized method to ensure only one thread can increment at a time
        public synchronized void increment() {
            count++;
        }

        // Non-synchronized method (can lead to race conditions if not careful)
        public void incrementUnsynchronized() {
            count++;
        }

        // Synchronized block to ensure only one thread can increment at a time
        public void incrementWithSyncBlock() {
            // Other non-critical code could go here
            synchronized (this) { // Acquires the lock on the current Counter instance
                count++;
            }
            // Other non-critical code could go here
        }

        public int getCount() {
            return count;
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Demonstrating Thread creation by extending Thread class ---");
        MyThread thread1 = new MyThread("Thread-1");
        thread1.start(); // Start the thread

        MyThread thread2 = new MyThread("Thread-2");
        thread2.start(); // Start another thread

        try {
            // Wait for threads to finish before proceeding
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted during join.");
        }

        System.out.println("\n--- Demonstrating Thread creation by implementing Runnable interface ---");
        MyRunnable runnable1 = new MyRunnable("Runnable-1");
        Thread thread3 = new Thread(runnable1);
        thread3.start();

        MyRunnable runnable2 = new MyRunnable("Runnable-2");
        Thread thread4 = new Thread(runnable2);
        thread4.start();

        try {
            thread3.join();
            thread4.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted during join.");
        }

        System.out.println("\n--- Demonstrating Thread Synchronization ---");
        Counter counter = new Counter();

        // Create multiple threads to increment the counter
        Runnable incrementTask = () -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment(); // Using synchronized method
            }
        };

        Thread[] incrementThreads = new Thread[5];
        for (int i = 0; i < incrementThreads.length; i++) {
            incrementThreads[i] = new Thread(incrementTask, "Incrementer-" + (i + 1));
            incrementThreads[i].start();
        }

        for (Thread t : incrementThreads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Final synchronized counter value: " + counter.getCount());

        // Demonstrating race condition with unsynchronized method (optional, for illustration)
        Counter unsyncedCounter = new Counter();
        System.out.println("\n--- Demonstrating Race Condition with Unsynchronized Method ---");

        Runnable unsyncedIncrementTask = () -> {
            for (int i = 0; i < 1000; i++) {
                unsyncedCounter.incrementUnsynchronized(); // Using unsynchronized method
            }
        };

        Thread[] unsyncedIncrementThreads = new Thread[5];
        for (int i = 0; i < unsyncedIncrementThreads.length; i++) {
            unsyncedIncrementThreads[i] = new Thread(unsyncedIncrementTask, "UnsyncedIncrementer-" + (i + 1));
            unsyncedIncrementThreads[i].start();
        }

        for (Thread t : unsyncedIncrementThreads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // This value will likely be less than 5000 due to race conditions
        System.out.println("Final unsynchronized counter value (likely incorrect due to race condition): " + unsyncedCounter.getCount());

        System.out.println("\n--- Demonstrating Synchronization with a Block ---");
        Counter blockSyncCounter = new Counter();
        Runnable blockSyncIncrementTask = () -> {
            for (int i = 0; i < 1000; i++) {
                blockSyncCounter.incrementWithSyncBlock();
            }
        };

        Thread[] blockSyncThreads = new Thread[5];
        for (int i = 0; i < blockSyncThreads.length; i++) {
            blockSyncThreads[i] = new Thread(blockSyncIncrementTask);
            blockSyncThreads[i].start();
        }

        for (Thread t : blockSyncThreads) {
            try { t.join(); } catch (InterruptedException e) { e.printStackTrace(); }
        }

        System.out.println("Final block-synchronized counter value: " + blockSyncCounter.getCount());
    }
}
