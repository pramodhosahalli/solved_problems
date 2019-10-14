#problem description can be found at https://www.codechef.com/OCT19B/problems/MARM/

t = int(input())
for _ in range(t):
    n,k = map(int,input().split())
    arr = [int(x) for x in input().split()]
    q=k//n
    if q!=0 and q%3!=0:
        for i in range(n):
            arr[i]=arr[i]^arr[n-i-1]
        if q%3==2:     
            for i in range(n):
                arr[i]=arr[i]^arr[n-i-1]
    else:
        if q!=0 and q % 3 == 0:
            if n % 2!=0:
                arr[n//2]=0
    rem = k % n
    for i in range(rem):
            arr[i]=arr[i]^arr[n-1-i]    
    for i in range(n):
        print(arr[i],end=" ")
