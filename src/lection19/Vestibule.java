package lection19;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Vestibule implements Runnable{
    private Thread t;
    private String threadName;
    private Lock lock;

    static LinkedList<Passenger> passengers;
    private Condition hasEnoughPassengers;

    public Vestibule(LinkedList<Passenger> passengers, String threadName) {
        this.passengers = passengers;
        this.threadName = threadName;
        this.lock = new ReentrantLock(false);
    }

    @Override
    public void run() {
        do {
            addPassenger();
            try {
                Thread.sleep(300);
            }catch (InterruptedException ex){
                ex.printStackTrace();

            }

        }while (true);
    }

    public void start(){
        System.out.println("Starting " +  threadName );
        if (t == null)
        {
            t = new Thread (this, threadName);
            t.start ();
        }
    }

    public LinkedList<Passenger> getPassengers() {
        return passengers;
    }

    public void addPassenger(){
        lock.lock();
        try {
            System.out.println(Thread.currentThread());
            Passenger pas = new Passenger("Passenger-" + (int)(Math.random()*1000) +"_" + (int)(Math.random() * 1000));
            passengers.add(pas);
            System.out.println();
            System.out.println("Added passenger - " + pas.toString());
            System.out.println();
        }finally {
            lock.unlock();
        }
    }
}
