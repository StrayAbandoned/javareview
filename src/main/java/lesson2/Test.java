package lesson2;

public class Test {
    public static void main(String[] args) {
        MyArrayList arrayList = new MyArrayList<>();
        arrayList.add("Hello");
        arrayList.add("Hello1");
        arrayList.add("Hello2");
        arrayList.add("Hello3");
        arrayList.add("Hello4",2);
        System.out.println(arrayList);
        arrayList.delete(2);
        System.out.println(arrayList);
        System.out.println(arrayList.get(2));

        MyLinkedList myLinkedList = new MyLinkedList<>();
        myLinkedList.add("Hello");
        myLinkedList.add("Hello1");
        myLinkedList.add("Hello2");
        myLinkedList.add(1,"Hello3");
        System.out.println(myLinkedList.get(1));
        myLinkedList.delete(3);
        System.out.println(myLinkedList.get(2));
    }
}
