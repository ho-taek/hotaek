import heapq
import sys

input = sys.stdin.readline
INF = int(1e9)
n,m = map(int, input().split())
graph = [[] for _ in range(n+1)]


for _ in range(m):
    a,b,c = map(int, input().split())
    graph[a].append((b,c))
    graph[b].append((a,c))

def dijkstra(start, end):
    q = []
    distance = [INF]*(n+1)
    heapq.heappush(q,(0, start))
    distance[start] = 0
    while q:
        dist,now = heapq.heappop(q)
        if distance[now] < dist:
            continue
        for i in graph[now]:
            count = dist + i[1]
            if count < distance[i[0]]:
                distance[i[0]] = count
                heapq.heappush(q,(count,i[0]))
    return distance[end]

v1, v2 = map(int, input().split())
v1_distance = dijkstra(1,v1) + dijkstra(v1,v2) + dijkstra(v2,n)
v2_distance = dijkstra(1,v2) + dijkstra(v2,v1) + dijkstra(v1,n)
print(v1_distance, v2_distance)
result = min(v1_distance,v2_distance)
print(result if result < INF else -1)
