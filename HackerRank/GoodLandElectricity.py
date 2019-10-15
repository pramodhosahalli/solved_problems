#Problem Description can be found at https://www.hackerrank.com/challenges/pylons/problem

def pylons(k, arr):
    if len(arr)==0:
        return 0
    covered = -1
    k-=1
    count = 0
    for i in range(0,len(arr)):
        if covered>=len(arr)-1:
            break
        if covered>=i:
            continue

        j = min(i+k,len(arr)-1)
        while j>=i:
            if arr[j]==1:
                break
            j-=1
        if j<i:
            minIndex = i-1
            while minIndex>=max(i-k,0):
                if  arr[minIndex]==1:
                    break
                minIndex-=1
            if minIndex < i-k:
                return -1
            covered = minIndex+k
            arr[minIndex]=0
        else:
            arr[j]=0
            covered=j+k
        count+=1
    return count

