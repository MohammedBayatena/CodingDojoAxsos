#1
def biggiesize(list):
    for index, item in enumerate(list):
        if item > 0:
            list[index] = "Big"
    return list
#2
def countpos(list):
    count=0
    for item in list:
        if item > 0:
            count+=1
    list[len(list)-1]=count
    return list
#3
def sum(list):
    sum=0
    for item in list:
        sum+=item
    return sum
#4
def average(list):
    return  ( float(sum(list))/length(list))
#5
def length(list):
    return len(list)

#6
def getmin(list):
    min=list[0]
    for item in list:
        if item < min:
            min = item
    return min

#7
def getmax(list):
    max=list[0]
    for item in list:
        if item > max:
            max = item
    return max
#8
def ultimateanalys(list):
    mydict={}
    mydict['sumTotal']=sum(list)
    mydict['average']=average(list)
    mydict['minimum']=getmin(list)
    mydict['maximum']=getmax(list)
    mydict['length']=length(list)
    return mydict

#9
def reverselist(list):
     revlist= list.copy()
     revlist.reverse()
     list= revlist.copy()
     return list


# print(biggiesize([-1, 3, 5, -5]))
# print(countpos([1,6,-4,-2,-7,-2]))
# print(sum([1,2,3,4]))
# print(average([1,2,3,4]))
# print(getmin([37,2,1,-9]))
# print(getmax([37,2,1,-9]))
# print(ultimateanalys([37,2,1,-9]))
# print(reverselist([37,2,1,-9]))

