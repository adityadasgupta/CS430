def maxSubArr(arr):
    largest = 0
    current = 0

    for i in range(0,len(arr)):
        j = i
        while j<=len(arr):
            curArr = arr[i:j]
            print(curArr)
            current = sum(curArr) #current subarray
            if current > largest:
                largest = current
            j = j+1
    return largest

l1 = [7,20,-300,65,810,-21]
maxSubArr(l1)
