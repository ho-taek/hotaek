import sys
from collections import deque

input = sys.stdin.readline

n,m,k,x = map(int,input().split())

graph = [[] for _ in range(n+1)]

for i in range(m):
    a,b = map(int,input().split())
    graph[a].append(b)

dist = [-1]*(n+1)
dist[x] = 0

queue = deque([x])

while queue:
    now = queue.popleft()
    for i in graph[now]:
        if dist[i] == -1:
            dist[i] = dist[now] + 1
            queue.append(i)

check = False
for i in range(1,n+1):
    if dist[i] == k:
        print(i)
        check = True

if check == False:
    print(-1)




