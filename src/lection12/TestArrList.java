package lection12;

public class TestArrList {
    public static void main(String [] args){
        Worker master = new Worker("Master", 100);
        ArrayListSample<Worker> workers = new ArrayListSample<>();
        workers.add(new Worker("Ivan Alco", 1));
        workers.add(new Worker("Vasyl Pots", 2));
        workers.add(new Worker("John Shepard", 10));
        workers.add(new Worker("Sashok", 2));

        ArrayListSample<Worker> workers2 = new ArrayListSample<>();
        workers2.add(new Worker("Sample", 3));

        ArrayListSample<lection12.Manager> managers = new ArrayListSample<>();
        managers.add(new Manager("Lesly", 10, "MBA manager"));
        managers.add(new Manager("Jenn", 6, "Simple manager"));

        ArrayListSample<Instrument> instrumentArrayListSample = new ArrayListSample<>();
        instrumentArrayListSample.add(new Instrument("Hammer", 0));

//        int i = 0;
//        while (i < workers.getSize()){
//            System.out.println(workers.getElement(i).toString());
//            i++;
//        }
        System.out.println("W Size - " + workers.getSize());
        System.out.println("M Size - " + managers.getSize());
//        System.out.println(workers.toString());
//        System.out.println();

//        LargestChecker checker = new LargestChecker();
//        System.out.println("Is " + master.getName() + " 'largest' worker - " + checker.isLargest(workers, master));
//
//        System.out.println(workers.compareCollectionLength(workers2));
        workers.addCollection(managers);
        System.out.println("W Size - " + workers.getSize());
        System.out.println(workers.toString());

        System.out.println(workers.getElement(2));
        workers.removeElementByIndex(2);
        System.out.println(workers.toString());
        System.out.println("W Size - " + workers.getSize());
        System.out.println(workers.getElement(2));
    }
}
