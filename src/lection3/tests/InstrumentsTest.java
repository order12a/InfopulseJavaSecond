package lection3.tests;

import lection3.Engineer;
import lection3.Worker;
import lection3.interfaces.LocksmithWork;
import lection3.interfaces.TurnerWork;

public class InstrumentsTest {

    public static void main(String[] args){
        Worker worker = new Worker();
        Engineer engineer = new Engineer();

        worker.drill(LocksmithWork.Instruments.Drill);
        worker.executeLocksmithWork();

        System.out.println();

        engineer.measure(TurnerWork.TurnerInstruments.Spectrophotometer);
        engineer.executeTurnerWork();
    }
}
