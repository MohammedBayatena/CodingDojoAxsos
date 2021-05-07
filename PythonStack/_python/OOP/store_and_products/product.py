class Product:

    def __init__(self,id,name,price,category):
        self.name=name
        self.id = id
        self.price=price
        self.category=category

    def update_price(self, percent_change, is_increased):
        if(is_increased):
            self.price = self.price+ (percent_change*self.price)
        else:
            self.price = self.price-(percent_change*self.price)
        return self.price

    def print_info(self):
        print("Product ID is ",self.id)
        print("Product Name is ",self.name)
        print("Product Price is ",self.price,"$")
        print("Product Category is ", self.category)





