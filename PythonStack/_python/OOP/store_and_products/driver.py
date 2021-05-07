from store import *
from product import *


store = Store("Mohammad's Store")


p1 = Product(1,"Rice",15,"Food")
p2 = Product(2,"Chocolate",1,"Food")
p3 = Product(3,"Lighter",2,"Tools")

store.add_product(p1)
store.add_product(p2)
store.add_product(p3)

store.inflation(.2)
store.set_clearance(.6,"Food")
store.sell_product(1)
store.display_storage()



