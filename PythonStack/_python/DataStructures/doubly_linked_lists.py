# node structure
class Node:
    # constructor to create a new node
    def __init__(self, data):
        self.data = data
        self.next = None
        self.prev = None


# class Linked List
class LinkedList:
    # constructor to create an empty LinkedList
    def __init__(self):
        self.head = None

    # display the content of the list
    def PrintList(self):
        temp = self.head
        if (temp != None):
            print("The list contains:", end=" ")
            while (temp != None):
                print(temp.data, end=" ")
                temp = temp.next
            print()
        else:
            print("The list is empty.")

    # Add new element at the end of the list

    def push_back(self, newElement):
        newNode = Node(newElement)
        if (self.head == None):
            self.head = newNode
            return
        else:
            temp = self.head
            while (temp.next != None):
                temp = temp.next
            temp.next = newNode
            newNode.prev = temp

        # Add new element at the start of the list

    def push_front(self, newElement):
        newNode = Node(newElement)
        if (self.head == None):
            self.head = newNode
            return
        else:
            self.head.prev = newNode
            newNode.next = self.head
            self.head = newNode

        # Inserts a new element at the given position

    def push_at(self, newElement, position):
        newNode = Node(newElement)
        if (position < 1):
            print("\nposition should be >= 1.")
        elif (position == 1):
            newNode.next = self.head
            self.head.prev = newNode
            self.head = newNode
        else:
            temp = self.head
            for i in range(1, position - 1):
                if (temp != None):
                    temp = temp.next
            if (temp != None):
                newNode.next = temp.next
                newNode.prev = temp
                temp.next = newNode
                if (newNode.next != None):
                    newNode.next.prev = newNode
            else:
                print("\nThe previous node is null.")

        # Delete first node of the list

    def pop_front(self):
        if (self.head != None):
            temp = self.head
            self.head = self.head.next
            temp = None
            if (self.head != None):
                self.head.prev = None

        # Delete last node of the list

    def pop_back(self):
        if (self.head != None):
            if (self.head.next == None):
                self.head = None
            else:
                temp = self.head
                while (temp.next.next != None):
                    temp = temp.next
                lastNode = temp.next
                temp.next = None
                lastNode = None

        # Delete an element at the given position

    def pop_at(self, position):
        if (position < 1):
            print("\nposition should be >= 1.")
        elif (position == 1 and self.head != None):
            nodeToDelete = self.head
            self.head = self.head.next
            nodeToDelete = None
            if (self.head != None):
                self.head.prev = None
        else:
            temp = self.head
            for i in range(1, position - 1):
                if (temp != None):
                    temp = temp.next
            if (temp != None and temp.next != None):
                nodeToDelete = temp.next
                temp.next = temp.next.next
                if (temp.next.next != None):
                    temp.next.next.prev = temp.next
                nodeToDelete = None
            else:
                print("\nThe node is already null.")

        # Search an element

    def SearchElement(self, searchValue):
        temp = self.head
        found = 0
        i = 0

        if (temp != None):
            while (temp != None):
                i += 1
                if (temp.data == searchValue):
                    found += 1
                    break
                temp = temp.next
            if (found == 1):
                print(searchValue, "is found at index =", i)
            else:
                print(searchValue, "is not found in the list.")
        else:
            print("The list is empty.")

        # Delete first node by key

    def pop_first(self, key):
        temp = self.head
        if (temp != None):
            if (temp.data == key):
                nodeToDelete = self.head
                self.head = self.head.next
                nodeToDelete = None
                if (self.head != None):
                    self.head.prev = None
            else:
                while (temp.next != None):
                    if (temp.next.data == key):
                        nodeToDelete = temp.next
                        temp.next = temp.next.next
                        if (temp.next != None):
                            temp.next.prev = temp
                        nodeToDelete = None
                        break
                    temp = temp.next


if __name__ == "__main__":
    list1 = LinkedList()

    for i in range(7):
        list1.push_back(i)

    list1.PrintList()
    print("-"*30)
    list1.push_back(8)
    list1.push_front(55)
    list1.pop_at(1)
    list1.pop_first(5)
    list1.push_at(999,3)
    list1.pop_at(3)
    list1.PrintList()
