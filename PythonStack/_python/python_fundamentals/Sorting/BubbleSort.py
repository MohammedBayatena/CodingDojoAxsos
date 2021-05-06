arr = [1,5,3,2,0,8]
for i in range(len(arr)):
    for j in range(0,len(arr)-1-i):
        if arr[j] > arr[j+1]:
            arr[j],arr[j+1] = arr[j+1],arr[j]

print(arr)

