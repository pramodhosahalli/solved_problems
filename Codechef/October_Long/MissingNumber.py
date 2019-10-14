# Problem description can be found at https://www.codechef.com/OCT19B/problems/MSNG

t = int(input())
for _ in range(t):
    n = int(input())
    arr = [0 for i in range(n)]
    brr = [0 for i in range(n)]
    
    x = 100000000000000
    for i in range(n):
        arr[i],brr[i] = map(str,input().split())
        if int(arr[i])!=-1:
            x = min(x,int(brr[i],int(arr[i])))
    
    #case 1 where atleast one of inputs has base!=-1
    if x != 100000000000000:
        i = 0
        while i < n:
            #if base!=-1 and value got from that base is not equal to x then its not possible break
            if int(arr[i])!=-1 and int(brr[i],int(arr[i]))!=x:
                break
            count = 0
            for b in range(2,37):
                try:
                    kk = int(brr[i],b)
                    if kk == x:
                        count=1
                        break
                except:
                    value = 3
            if count==0:
                break
            i+=1
        
        if i==n and x <=1000000000000:
            print(x)
        else:
            print(-1)
        continue
        
    
    _hash = {}
    _thash = {}
    for b in range(2,37):
        for i in range(n):
            num = brr[i]
            try:
                val = int(num,b)
                if val in _thash.keys():
                    cc = _thash[val]
                    if i in cc:
                        continue
                    cc.append(i)
                    _thash[val] = cc
                else:
                    cc = []
                    cc.append(i)
                    _thash[val] = cc
                if val in _hash.keys():
                    _hash[val]+=1
                else:
                    _hash[val]=1
                if _hash[val]==n:
                    x = min(x,val)
            except:
                value  = 3
    if x<=1000000000000:
        print(x)
    else:
        print(-1)
