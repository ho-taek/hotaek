n = int(input())

for i in range(1,n+1):
    m = list(map(int, input().split()))
    print("#%d"%i,max(m))