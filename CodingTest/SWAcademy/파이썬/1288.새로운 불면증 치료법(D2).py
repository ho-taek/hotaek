T = int(input())

for t in range(1,T+1):
    n = int(input())
    s = set()
    answer = 1
    while True:
        for i in list(str(n)):
            s.add(i)
        if len(s) == 10:
            break
        n //= answer
        answer += 1
        n *= answer
    print("#%d"%t, n)
    