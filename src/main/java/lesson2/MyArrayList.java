package lesson2;

import java.util.Arrays;

public class MyArrayList<E> {
    private int size;
    Object[] list;

    public MyArrayList() {
        list = new Object[]{};
        size = list.length;
    }

    public boolean add(E object) {
        size = size + 1;
        list = Arrays.copyOf(list, size);
        list[size - 1] = object;
        return true;
    }

    public boolean add(E object, int index) {
        if (index < 0 || index > list.length) {
            throw new IndexOutOfBoundsException("Wrong index");
        }
        size = size + 1;
        Object[] tempArray = Arrays.copyOf(list,  index);
        Object[] tempArray2 = Arrays.copyOfRange(list, index, list.length);
        Object[] finalArray = new Object[size];
        for (int i = 0; i< tempArray.length; i++){
            finalArray[i] = tempArray[i];
        }
        finalArray[index] = object;
        for (int i = 0, j = index+1; i< tempArray2.length; i++,j++){
            finalArray[j] = tempArray2[i];
        }
        list = finalArray;
        return true;
    }

    public void delete(int index){
        if (index < 0 || index > list.length) {
            throw new IndexOutOfBoundsException("Wrong index");
        }
        size = size - 1;
        Object[] tempArray = Arrays.copyOf(list,  index);
        Object[] tempArray2 = Arrays.copyOfRange(list, index+1 , list.length);
        Object[] finalArray = new Object[size];
        for (int i = 0; i< tempArray.length; i++){
            finalArray[i] = tempArray[i];
        }
        for (int i = 0, j = index; i< tempArray2.length; i++,j++){
            finalArray[j] = tempArray2[i];
        }
        list = finalArray;

    }

    public E get(int index){
        if (index < 0 || index > list.length) {
            throw new IndexOutOfBoundsException("Wrong index");
        }
        return (E) list[index];
    }



    @Override
    public String toString() {
        return "MyArrayList{" +
                 Arrays.toString(list) +
                '}';
    }
}
