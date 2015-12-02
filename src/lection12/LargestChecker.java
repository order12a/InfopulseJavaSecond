package lection12;

/**
 * Created by order on 30.11.15.
 */
public class LargestChecker{
    public<T extends Comparable<T>> boolean isLargest(ArrayListSample<T> collection,  T worker){
        boolean flag = true;
        int i = 0;
        while (i < collection.getSize() - 1){
            flag = flag & compare(worker, collection.getElement(i)) > 0;
            i++;
        }
        return flag;
    }

    public<T extends Comparable> int compare(T o1, T o2) {
        return o1.compareTo(o2);
    }
}
