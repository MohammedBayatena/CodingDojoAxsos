a = [6,5,3,1,8,7,2,4]
for i in range(1,len(a)):
    print(f"iam at index [{i}]")
    print("[")
    j=i-1 #for comparsion with whatever behind
    k=i #to keep track of the index of the swapped item
    while(a[k] < a[j] and k != 0):
        print(f"item {a[k]} is less than item {a[j]} , we swap values")
        a[k], a[j] = a[j], a[k]
        print(" == > array is now ", a)
        j-=1
        k-=1
    print("]")

print("\t\nFinal result is: " , a)


