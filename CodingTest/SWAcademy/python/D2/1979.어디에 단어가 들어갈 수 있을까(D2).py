

T = int(input())

for t in range(1,T+1):
    n,k = map(int, input().split())

    li = [list(map(int, input().split())) for _ in range(n)]
    answer = 0

    for i in range(n):
        check = 0
        for j in range(n):
            if li[i][j] == 1:
                check += 1
                if check > k:
                    check = 0
                    continue
                if (j == n-1) and (check == k):
                    answer += 1
            else:
                if check == k:
                    answer += 1
                    check = 0
                else:
                    check = 0
                    continue
        row = 0
        for r in range(n):
            if li[r][i] == 1:
                row += 1
                if row > k:
                    row = 0
                    continue
                if (r == n-1) and (row == k):
                    print(r,i,2)
                    answer += 1
            else:
                if row == k:
                    print(r,i,3)
                    answer += 1
                    row = 0
                else:
                    row = 0
                    continue
    print("#%d"%t,answer)
                    
