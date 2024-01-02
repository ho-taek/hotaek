t = int(input())

for t in range(1, t + 1):
    n,m = map(int, input().split())
    li = [list(map(int, input().split())) for _ in range(n)]
    answer = 0
    for i in range(n-m+1):
        for j in range(n-m+1):
            tmp = 0
            for a in range(i,i+m):
                for b in range(j,j+m):
                    tmp += li[a][b]
            if tmp > answer:
                answer = tmp
    print("#%d"%t, answer)
            
