n = int(input())

for i in range(n):
    a = int(input())
    li = list(map(int, input().split()))
    answer = [0]*101
    result = 0
    for i in li:
        answer[i] += 1
        if answer[i] > result : result = answer[i]
    print("#%d"%a, result)