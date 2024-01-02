


t = int(input())


for t in range(1,t+1):
    li = []

    for i in range(9):
        li.append(list(map(int, input().split())))

    result = 0
    #행,열 확인
    for i in range(9):
        answer = [1]*10
        for x in range(9):
            answer[li[i][x]] -= 1
        if answer.count(0) != 9:
            result = -1
            break
        answer = [1]*10
        for y in range(9):
            answer[li[y][i]] -= 1
        if answer.count(0) != 9:
            result = -1
            break
    if result == -1:
        print("#%d -1"%t)
        continue
        




