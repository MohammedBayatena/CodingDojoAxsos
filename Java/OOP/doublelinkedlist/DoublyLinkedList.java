package OOP.doublelinkedlist;

public class DoublyLinkedList {
    public Node head;
    public Node tail;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    // the push method will add a new node to the end of the list
    public void push(Node newNode) {
        // if there is no head in the list, aka, an empty list, we set the newNode to be the head and tail of the list
        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
            return;
        }

        // first find the lastNode in the list
        // then, set the lastNode's next to be the newNode;
        // then, we have to set the previous of the lastNode to the lastNode that we found previously.
        // finally, set the list's tail to be the node that we have added
        Node lastNode = this.tail;
        lastNode.next = newNode;
        newNode.previous = lastNode;
        this.tail = newNode;
    }

    public void printValuesForward() {
        // find the first node, aka head.
        Node current = this.head;

        // while the current node exists...
        System.out.print("Head -> ");
        while (current != null) {
            // print it's value
            System.out.print(current.value);
            System.out.print(" -> ");
            // and move on to it's next node.
            current = current.next;
        }
        System.out.print("Null\n");
    }

    public void printValuesBackward() {
        // find the Last node, aka tail.
        Node current = this.tail;
        // while the current node exists...
        System.out.print("Tail -> ");
        while (current != null) {
            // print it's value
            System.out.print(current.value);
            System.out.print(" -> ");
            // and move on to it's previous node.
            current = current.previous;
        }
        System.out.print("Head\n");
    }

    public Node pop() {
        Node toBeReturned = this.tail;
        Node previous = this.tail.previous;
        previous.next = null;
        this.tail = previous;
        return toBeReturned;
    }

    public Boolean contains(Integer value) {
        //Search from both sides Head/Tail and stop when both pointers meet
        Node current1 = this.head;
        Node current2 = this.tail;
        while (current1 != current2) {
            if (current1.value == value || current2.value == value) {
                return true;
            }
            current1 = current1.next;
            current2 = current2.previous;
        }
        return false;
    }

    public int size() {
        int count = 0;
        Node current1 = this.head;
        while (current1 != null) {
            count += 1;
            current1 = current1.next;
        }
        return count;
    }

    public void insertAt(Node newNode, int index) {
        if (head == null) {
            System.out.println("Empty List");
        } else {
            if (index == 0) {
                newNode.next = this.head;
                this.head.previous = newNode;
                this.head = newNode;
            } else if (index >= size()) {
                System.out.println("Warning: Index Outside linked list length, Value added to last instead!");
                push(newNode);
            } else {
                Node current = this.head;
                int count = 0;
                while ((count != index) && current.next != null) {
                    current = current.next;
                    count++;
                }
                newNode.previous = current.previous;
                newNode.next = current;
                Node temp = current.previous;
                current.previous = newNode;
                temp.next = newNode;
            }
        }
    }

    public void removeAt(int index) {
        if (head == null) {
            System.out.println("Empty List");
        } else {
            if (index == 0) {
                Node temp = this.head;
                this.head = this.head.next;
                temp.next = null;
                temp.previous = null;
            } else if (index >= size()) {
                System.out.println("Warning: Index Outside linked list length,Use pop() to delete last,Nothing Removed! ");
            } else {
                Node current = this.head;
                int count = 0;
                while ((count != index) && current.next != null) {
                    current = current.next;
                    count++;
                }
                Node temp = current;
                current.previous.next = current.next;
                temp.next = null;
                temp.previous = null;
            }
        }
    }

    public Boolean isPalindrome() {
        Node current1 = this.head;
        Node current2 = this.tail;
        while (current1 != current2) {
            if (current1.value != current2.value) {
                return false;
            }
            current1 = current1.next;
            current2 = current2.previous;
        }
        return true;
    }


}






