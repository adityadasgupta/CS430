#Team name: null
#Team members: Aditya Dasgupta(seat 14) and Devyani Gauri(Seat 25)

#running time -> O(n^2)
def maxSubArr(arr):
    #set the largest and the current to 0
    largest = 0 
    current = 0

    for i in range(0,len(arr)):   #the index of the first element of a subarray is denoted by i
        j = i
        while j<=len(arr):        #after every iteration of the while loop, the size of the subarray is increased by 1.
            curArr = arr[i:j]     #creation of the subarray
            print(curArr)
            current = sum(curArr) #sum of current subarray
            if current > largest: #checks if current subarray is larger than the last recorded largest subarray
                largest = current #sets largest to current
            j = j+1
    return largest

#test case [should return 875]
l1 = [7,20,-300,65,810,-21]
maxSubArr(l1)
