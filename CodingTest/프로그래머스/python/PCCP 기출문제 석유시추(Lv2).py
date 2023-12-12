
from collections import deque
def solution(land):
    answer = 0
    
    index = len(land[0])
    result = [0]*index
    for i in range(len(land[0])):
        tmp = 0
        for j in range(len(land)):
            if land[j][i] == 1:
                tmp += bfs(land,j,i)
            
        result[i] = tmp
    print(land)
    return max(result)


def bfs(check,x,y):
    queue = deque()
    queue.append((x,y))
    check[x][y] = 0
    x_len = len(check)
    y_len = len(check[0])
    result = 1
    while queue:
        x,y = queue.popleft()
        dx = [0,0,-1,1]
        dy = [-1,1,0,0]
        
        for i in range(4):
            nx = x+dx[i]
            ny = y+dy[i]
            if nx >= 0 and nx < x_len and ny >=0 and ny < y_len:
                if check[nx][ny] == 1:
                    queue.append((nx,ny))
                    check[nx][ny] = 0
                    result += 1
    return result
            
        


