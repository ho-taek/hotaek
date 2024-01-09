t = int(input())

def rotate(m,d):
    n = len(m)
    li = [[0]*n for _ in range(n)]
    if d == 90:
        for i in range(n):
            for j in range(n):
                li[j][n-1-i] = m[i][j]
    elif d == 180:
        for i in range(n):
            for j in range(n):
                li[n-1-i][n-1-j] = m[i][j]
    else:
        for i in range(n):
            for j in range(n):
                li[n-1-j][i] = m[i][j]
    return li
for i in range(1,t+1):
    n = int(input())
    li = []
    for _ in range(n):
        li.append(list(map(int, input().split())))
    arr_90 = rotate(li,90)
    arr_180 = rotate(li,180)
    arr_270 = rotate(li,270)
    print("#%d"%i)
    for i in range(n):
        for x in range(n):
            print(arr_90[i][x], end='')
        print(end=' ')
        for y in range(n):
            print(arr_180[i][y], end='')
        print(end=' ')
        for z in range(n):
            print(arr_270[i][z], end='')
        print()
