T = int(input())
li = [2,3,5,7,11]

for t in range(1, T+1):
    n = int(input())
    answer = []
    for i in li:
        tmp = 0
        while n % i == 0:
            tmp += 1
            n /= i
        answer.append(tmp)
    print("#%d"%t, ' '.join(str(e) for e in answer))
