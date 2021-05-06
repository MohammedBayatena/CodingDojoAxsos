import random
import math
def randInt(min= 0   , max= 100  ):
    if min > max:
        temp = max
        max=min
        min=temp
        print("Warning: min was found to be larger than max. We switched the min/max values for you")
    num = math.ceil(random.random() * (max-min))+min #this line
    # num = random.randint(min,max) # or use this single line
    return num
# print(randInt()) 		    # should print a random integer between 0 to 100
# print(randInt(max=50)) 	    # should print a random integer between 0 to 50
# print(randInt(min=50)) 	    # should print a random integer between 50 to 100
# print(randInt(min=50, max=500))    # should print a random integer between 50 and 500
# print(randInt(min=10, max=-9))