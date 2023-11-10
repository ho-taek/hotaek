import sys 
from collections import deque

input = sys.stdin.readline

n,m,v = map(int, input().split())

graph = [[] for _ in range(n + 1)]

for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)
visit_list = [False] * (n + 1)
visit_list2 = [False] * (n + 1)

def dfs(start):
    visit_list[start] = True
    print(str(start), end=' ')

    for i in graph[start]:
        if not visit_list[i]:
            dfs(i)

dfs(v)
print()

def bfs(start):
    queue = deque([start])
    visit_list2[start] = True

    while queue:
        a = queue.popleft()
        print(a, end=' ')
        for i in graph[a]:
            if not visit_list2[i]:
                queue.append(i)
                visit_list2[i] = True

bfs(v)
