package OOP.SingleLinkedList;

public class SinglyLinkedList {
    public Node head;

    public SinglyLinkedList() {
        this.head = null;
    }


    public Node removeLast() {
        Node node = null;
        Node runner = head;
        if (head == null) {
            System.out.println("List is Empty");
            return null;
        } else {
            while (runner.next.next != null) {
                runner = runner.next;
            }
            node = runner;
            runner.setNext(null);
            return node;
        }
    }


    // SLL methods go here. As a starter, we will show you how to add a node to the list.
    public void add(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            Node runner = head;
            while (runner.next != null) {
                runner = runner.next;
            }
            runner.next = newNode;
        }
    }

    public void printValues() {
        if (head == null) {
            System.out.println("List is Empty");
        } else {
            Node runner = head;
            while (runner != null) {
                System.out.print(runner.getValue() + " -> ");
                runner = runner.next;
            }
            System.out.println("null");
        }
    }

    public Node searchValue(int value) {
        Node runner = head;
        if (runner == null) {
            System.out.println("List is Empty!");
        } else {
            while (runner != null) {
                if (runner.getValue() == value) {
                    return runner;
                }
                runner = runner.next;
            }
            System.out.println("Node with such value haven't been found in list!");
        }
        return null;
    }

    public Node removeAt(int index) {
        Node runner = head;
        Node toBeReturned = head;
        int count = index - 1;

        if (index == 0) {
            Node temp = head;
            head = head.next;
            return temp;
        }
        if (head == null) {
            System.out.println("List is Empty");
            return null;
        } else {
            while (count > 0 && runner.next != null) {
                runner = runner.next;
                count--;
            }
            if (runner.next != null) {
                Node temp = runner.next.next;
                toBeReturned = runner.next;
                toBeReturned.next = null;
                runner.next = temp;
            } else if (count > 0) {
                removeLast();
            }


        }

        return toBeReturned;

    }


}
