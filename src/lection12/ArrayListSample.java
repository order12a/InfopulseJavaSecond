package lection12;

import java.util.Arrays;

/**
 * Created by order on 30.11.15.
 */
public class ArrayListSample <T> {

    private Object[] initedArrList;
    private int size = 0;
    private static final int INITED_CAPACITY = 10;

    public ArrayListSample(){
        initedArrList = new Object[INITED_CAPACITY];
    }

    public void add(T element){
        if (initedArrList.length == size){
            enlargeArray();
        }
        initedArrList[size++] = element;
//        size++;
    }

    private T[] enlargeArray(){
        return Arrays.copyOf((T[]) initedArrList, initedArrList.length + INITED_CAPACITY);
    }

    public int getSize() {
        return size;
    }

    public T getElement(int index){
        if (!(index < 0) || !(index >= size)){
            return (T) initedArrList[index];
        }else {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + size);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < size){
            sb.append(getElement(i) + " ");
            i++;
        }

        return sb.toString();
    }

    public boolean isLargest(T element){
        int i = 0;
        int c =0;
        boolean flag = true;
        while (i < initedArrList.length){

        }
        return false;
    }

    public String compareCollectionLength(ArrayListSample<T> arrayListSample){
        if (this.size > arrayListSample.getSize()){
            return "This collection " + this.getClass().getName() + " with size " + getSize() + " is larger";
        }else if (this.size < arrayListSample.getSize()){
            return "This collection " + this.getClass().getName() + " with size " + getSize() + " is less than income collection.";
        }else {
            return "Collections are equal.";
        }
    }

    public void addCollection(ArrayListSample<? extends T> listSample){
        System.out.println("listSample size - " + listSample.getSize());
        for (int i = 0; i < listSample.getSize(); i++){
            add(listSample.getElement(i));
        }
    }

}
