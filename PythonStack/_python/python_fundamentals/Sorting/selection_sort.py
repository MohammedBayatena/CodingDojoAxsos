a = [1,5,3,2,0,8]
for  i,item in enumerate(a):
    for j in range(i,len(a)):
        if a[j] < a[i]:
            temp=a[i]
            a[i]=a[j]
            a[j]=temp
print(a)

