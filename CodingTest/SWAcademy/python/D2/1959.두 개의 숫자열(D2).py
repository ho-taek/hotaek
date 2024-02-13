t = int(input())

for t in range(1,t+1):
    n,m = map(int, input().split())
    if(n>m):
        big = n
        small = m
        big_list = list(map(int, input().split()))
        small_list = list(map(int, input().split()))
    else:
        small = n
        big = m
        small_list = list(map(int, input().split()))
        big_list = list(map(int, input().split()))
    answer = -int(1e9)
    for i in range(big-small+1):
        tmp = 0
        for j in range(small):
            tmp += small_list[j]*big_list[j+i]
        if tmp > answer:
            answer = tmp
    print("#%d"%t, answer)            