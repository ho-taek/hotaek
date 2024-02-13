T = int(input())

for t in range(1,T+1):
    a,b = map(int, input().split())

    tmp = a+b

    if tmp > 24:
        answer = tmp-24
    elif tmp == 24:
        answer = 0
    else:
        answer = tmp

    print("#%d"%t, answer)