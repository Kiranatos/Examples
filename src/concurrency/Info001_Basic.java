package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Info001_Basic {
    
    private static void delay(long m){
        try {
            Thread.sleep(m);
        } catch (InterruptedException ex) {
            Logger.getLogger(Info001_Basic.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args) {
        System.out.println("Примеры создания потоков:");
        
        System.out.println(" --- Нить №1 - анонимный класс по интерфейсу Runnable");
        Runnable thread1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Запуск Нити №1");
                delay(1000);
                System.out.println("Конец Нити №1");         
            }
        };
        thread1.run();
        
        System.out.println(" --- Нить №2 - анонимный класс наследуемый от класса Thread");
        Thread thread2 = new Thread() {
            @Override
            public void run() {
                System.out.println("Запуск Нити №2");
                delay(2000);
                System.out.println("Конец Нити №2");
            }
        };        
        thread2.start();
        
        System.out.println(" --- Нить №3 -  запуск через Thread, класса который импелментирует Runnable");
        Thread thread3 = new Thread(new A(3));        
        thread3.start();
        
        System.out.println(" --- Нить №4 -  запуск через Лямбду");
        new Thread(() -> System.out.println("Running Нить №4")).start();
        
        System.out.println(" --5-- Нить №5 -  запуск через Лямбду и Executors");
        ExecutorService ex = Executors.newFixedThreadPool(3);
        ex.submit(new A(5.1));
        ex.submit(new A(5.2));
        ex.submit(new A(5.3));
        ex.submit(new A(5.4));        
        ex.submit(new A(5.5));
        ex.submit(new A(5.6));
        ex.submit(new A(5.7));
        ex.submit(new A(5.8));
        
        
        System.out.println(" --6-- Нить №6 -  запуск через Лямбду и Executors");
        /*Executor could be used to start a new thread which is the preferred way to manage threads)*/
        Future t = Executors.newFixedThreadPool(10).submit(() -> System.out.println("Running Нить №6"));
        /*submit() method supports both Runnable and Callable
        
        shutdown() - Initiates an orderly shutdown in which previously submitted
        tasks are executed, but no new tasks will be accepted.
        Invocation has no additional effect if already shut down
        
        shutdownNow() - Attempts to stop all actively executing tasks,
        halts the processing of waiting tasks, and returns a list of the
        tasks that were awaiting execution*/
        
        ex.shutdown();
        
        /*НЕ ПРИДУМАЛ ЕЩЁ*/
        Executors.newFixedThreadPool(10, new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                 return new Thread();
            }
        });        
        Executors.newFixedThreadPool(10, runnable -> {
            return new Thread(runnable);
        });    
        Executors.newFixedThreadPool(10, Thread::new);    
        
        // JOIN
        final Thread thread = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (final InterruptedException exx) {
                // Reset the interruption status.
                Thread.currentThread().interrupt();
            }
            System.out.println("Exiting");
        });        
        thread.start();
        try {
            // It is recommended, whenever is appropriate and possible, to use timed out version of the available JDK API around concurrency.
            thread.join(TimeUnit.SECONDS.toMillis(10)); // So wait thread to complete and then the current thread resumes.
        } catch (InterruptedException ex1) {
            Logger.getLogger(Info001_Basic.class.getName()).log(Level.SEVERE, null, ex1);
        }
        
        
        /*
        As the alternative for the volatile field AtomicBoolean could be used, 
        where the changes made there have the same memory visibility guarantee, 
        but also provides more rich features (known as CAS - Compare-And-Swap, 
        which is also the base for the "lock-free" concurrency).*/
        
        /*
        There are mainly two types of the explicit locks available:
            Lock and
            ReadWriteLock  */
        
        //lock has to be always unlocked, otherwise it can lead to deadlock
       
        /*
        Lock lock = new Lock();
        lock.lock();
        try {
            // do some actions
        } finally { lock.unlock(); } 
        */
        
        /*
        Java provides set of concurrent data structures which could be found 
        in the java.util.concurrent package. The most notable ones are:
                ConcurrentMap
                BlockingQueue
                CopyOnWriteArrayList    and many many others*/
        
        
    }       
}

class A implements Runnable {
    private double n;
    A(double n) { this.n = n;}
    @Override
    public void run() {
        System.out.println("Запуск Нити №" + n);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Info001_Basic.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Конец Нити №" + n);
    }
}
