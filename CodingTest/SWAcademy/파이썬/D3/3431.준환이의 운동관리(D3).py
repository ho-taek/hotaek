T = int(input())

for t in range(1,T+1):
    l,u,x = map(int, input().split())
    answer = -1
    if x < l:
        answer = l-x
    elif x > u:
        answer = -1
    else:
        answer = 0
    
    print("#%d"%t, answer)