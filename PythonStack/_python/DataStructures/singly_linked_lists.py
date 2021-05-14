class Node:
    def __init__(self,value):
        self.value = value
        self.next = None

    def get_value(self):
        return self.value

    def get_next(self):
        return self.next

    def set_next(self,next):
        self.next = next

    def set_value(self, value):
        self.value = value

    def is_last(self):
        if self.next is None:
            return True
        else:
            return False

class SLList:

    def __init__(self):
        self.head = Node(0)

    def print_values(self):
        p = self.head.next
        while p is not None:
            print(p.get_value())
            p = p.next

    def find_last(self):
        p = self.head
        while p.next is not None:
            p = p.next
        return p

    def add_to_back(self, value):
        self.find_last().set_next(Node(value))

    def add_to_front(self, value):
        node = Node(value)
        node.next=self.head.next
        self.head.next=node

    def delete_at_index(self,index):
        previous = self.head
        node= None
        for i in range(index):
            previous= previous.next
        node=previous.next
        previous.set_next(previous.next.next)
        del node

    def delete_from_front(self):
        node = self.head.next
        self.head.next = self.head.next.next
        del node

    def get_previous(self,node):
        previous = self.head
        last = self.find_last()
        while previous.next != node:
            previous = previous.next
        return previous

    def delete_from_back(self):
        last = self.find_last()
        self.get_previous(last).next = None
        del last

    def update_at_index(self,index,value):
        node = self.head
        for i in range(index+1):
            node = node.next
        node.set_value(value)

    def remove_val_first_occurence(self, value):
        count = 0
        found=0
        runner = self.head.next
        while runner != value and runner is not None:
            if runner.get_value() == value:
                found=1
                break
            else:
                count+=1
                runner=runner.next
        if found:
            self.delete_at_index(count)

    def insert_at_index(self,index,value):
        previous = self.head
        node= None
        for i in range(index):
            previous= previous.next

        newnode = Node(value)
        newnode.next = previous.next
        previous.next = newnode


if __name__ == "__main__":

    list1 = SLList()
    for i in range(5):
        list1.add_to_back(i)

    list1.print_values()
    print("-"*30)
    list1.remove_val_first_occurence(5)
    list1.insert_at_index(3,555)
    list1.insert_at_index(4,9999)
    list1.print_values()








