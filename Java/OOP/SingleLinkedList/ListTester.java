package OOP.SingleLinkedList;

public class ListTester {
    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.add(3);
        sll.add(4);
        sll.add(10);
        sll.add(5);
        sll.add(15);
        sll.add(2);
        sll.printValues();
        Node result = sll.removeLast(); //removeLast() is same as remove()
        sll.printValues();
        System.out.println(sll.searchValue(5));
        System.out.println(sll.searchValue(58));
        sll.removeAt(0);
        sll.printValues();
        sll.removeAt(3);
        sll.printValues();
    }
}