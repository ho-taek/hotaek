import sys
from collections import deque

input = sys.stdin.readline

n,l = map(int, input().split())
num = list(map(int, input().split()))

d = deque()

for i in range(n):
    #들어올 때마다 deque 안에 있는 큰 애들을 삭제
    while d and d[-1][0] >= num[i]:
        d.pop()
    # 인덱스 비교해서 l만큼 차이나면 삭제
    d.append((num[i],i))
    if d[0][1] <= i - l:
        d.popleft()
    print(d[0][0], end=" ")