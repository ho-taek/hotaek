n = int(input())

for i in range(n):
    m = filter(lambda x : x%2!=0,list(map(int,input().split())))
    print(sum(m))