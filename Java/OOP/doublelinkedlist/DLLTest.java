package OOP.doublelinkedlist;

public class DLLTest {
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        Node n1 = new Node(10);
        Node n2 = new Node(20);
        Node n3 = new Node(50);
        Node n4 = new Node(60);
        Node n5 = new Node(80);
        Node n6 = new Node(100);
        //Push Test
        dll.push(n1);
        dll.push(n2);
        dll.push(n3);
        dll.push(n4);
        dll.push(n5);
        dll.push(n6);
        //Success!
        //Print Test
        dll.printValuesForward();
        dll.printValuesBackward();
        //Success!
        //Pop Test
        dll.pop();
        dll.pop();
        dll.printValuesForward();
        //Success!
        //Contains Test
        System.out.println("Contains 100: " + dll.contains(100));
        System.out.println("Contains 20: " + dll.contains(20));
        //Success!
        //Test Size
        System.out.println("Size: " + dll.size());
        //Success!
        //Test Insert at Index
        dll.insertAt(new Node(555), 0);
        dll.insertAt(new Node(666), 99);
        dll.insertAt(new Node(777), 3);
        dll.printValuesForward();
        //Success!
        //Test Remove at Index
        dll.removeAt(0);
        dll.removeAt(99);
        dll.removeAt(3);
        dll.printValuesForward();
        //Success!
        //Test is Palindrome
        DoublyLinkedList palindromelist = new DoublyLinkedList();
        palindromelist.push(new Node(1));
        palindromelist.push(new Node(2));
        palindromelist.push(new Node(3));
        palindromelist.push(new Node(2));
        palindromelist.push(new Node(1));
        palindromelist.printValuesForward();
        System.out.println("List is Palindrome: " + palindromelist.isPalindrome());
        //Success!
    }
}
