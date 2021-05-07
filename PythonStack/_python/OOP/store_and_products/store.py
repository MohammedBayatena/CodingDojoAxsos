from product import *

class Store:

    def __init__(self,name):
        self.list_of_products = []
        self.name = name

    def add_product(self, new_product):
        self.list_of_products.append(new_product)

    def sell_product(self, id):
        found = 0
        for index, item in enumerate(self.list_of_products):
            if item.id == id:
                self.list_of_products.pop(index)
                found = 1
        if (not found):
            print("Warning: Item to be removed is not in store, Nothing updated!")



    def inflation(self, percent_increase):
        for item in self.list_of_products:
            item.update_price(percent_increase,True)

    def set_clearance(self, category, percent_discount):
        for item in self.list_of_products:
            if item.category == category:
                item.update_price(percent_discount,False)

    def print_info(self):
        print("Store Name is :", self.name)
        self.display_storage()

    def display_storage(self):
        for item in self.list_of_products:
            item.print_info()
            print("-"*30)




