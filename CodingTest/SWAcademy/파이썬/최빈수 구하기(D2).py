t = int(input())

for i in range(1,n+1):
    n,m = map(int, input().split())
    if len(n) > len(m):
    minLi = 
    li = list(map(int, input().split()))
    answer = [0]*101
    result = 0
    for i in li:
        answer[i] += 1
        if answer[i] >= answer[result] : result = i
    print("#%d"%a, result)