import sys

input = sys.stdin.readline

n,m = map(int, input().split())
N = []
for i in range(n):
    N.append(int(input()))

start = 1
end = max(N)

result = 0
while start <= end:
    total = 0
    mid = (end+start) // 2
    for i in N:
        total += i//mid
    
    if total < m:
        end = mid - 1
    else:
        result = mid
        start = mid + 1
print(result)