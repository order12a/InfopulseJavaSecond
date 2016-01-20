package lection19;

import java.util.LinkedList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Escalator implements Runnable{
    private Thread t;
    private String threadName;
    private Lock lock;

    static volatile LinkedList<Passenger> passengersOut;
    static volatile LinkedList<Passenger> passengersIn;

    public Escalator(LinkedList<Passenger> passengersIn, String threadName) {
        this.passengersIn = passengersIn;
        passengersOut = new LinkedList<>();
        this.threadName = threadName;
        this.lock = new ReentrantLock(false);
    }

    @Override
    public void run() {
        for (Passenger passenger:passengersIn){
            System.out.println(threadName + " in for loop so we have passenger in list " + passengersIn.size());
            System.out.println(passenger.toString());
        }
//            lock.lock();
            do {
                transferPassengersFromVestibuleToEscalator();
                try {
                    Thread.sleep(1000);
                }catch (InterruptedException ex){
                    ex.printStackTrace();
                }finally {
//                    lock.unlock();
                }
            }while (passengersIn.size() > 0);
    }

    public void transferPassengersFromVestibuleToEscalator(){
        System.out.println("In method that try add passenger to escalator, passengers count " + passengersIn.size() + " thread " + Thread.currentThread());
        synchronized (passengersIn) {
        while (passengersIn.size() > 0){
                System.out.println("Escalator before attempt to get passenger, thread " + Thread.currentThread());
                passengersOut.add(passengersIn.poll());
                System.out.println("Added passengers to escalator.");
                System.out.println(threadName);
            }
        }
    }

    public void start(){
        System.out.println("Starting " +  threadName );
        if (t == null)
        {
            t = new Thread (this, threadName);
            t.start ();
        }
    }
}
