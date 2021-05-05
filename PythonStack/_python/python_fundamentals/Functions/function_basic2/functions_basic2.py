#1
def countdown(number):
    list =[]
    for num in range(number,0,-1):
        list.append(num)
    return list
#2

def printandret(list):
    print(list[0])
    return list[1]
#3
def firstpluslength(list):
    return int(list[0]) + int(len(list))
#4
def valuesgreaterthansec(list):
    newlist=[]
    if len(list) > 1:
        for item in list:
            if item > list[1]:
                newlist.append(item)
        print("List Length: "+ str(len(newlist)))
        return newlist
    else:
        return False
#5
def thislengththatval(size,value):
    newlist=[]
    for index in range(size):
        newlist.append(value)
    return newlist

# print(countdown(5))
# print(printandret([1,2]))
# print(firstpluslength([1,2,3,4,5]))
# print(valuesgreaterthansec([5,2,3,2,1,4]))
# print(thislengththatval(6,2))
