import sys

input = sys.stdin.readline

n = int(input())
data = list(map(int, input().split()))
plus, minus, mul, div = map(int,input().split())

max_value = -1e9
min_value = 1e9
def dfs(i, now):
    global min_value, max_value, plus, minus, div, mul

    if i == n:
        min_value = min(min_value, now)
        max_value = max(max_value, now)
    else:
        if plus > 0:
            plus -= 1
            dfs(i+1, now + data[i])
            plus += 1
        if minus > 0:
            minus -= 1
            dfs(i+1, now - data[i])
            minus += 1
        if mul > 0:
            mul -= 1
            dfs(i+1, now*data[i])
            mul += 1    
        if div > 0:
            div -= 1
            dfs(i+1, int(now/data[i]))
            div += 1
       
    
dfs(1, data[0])

print(max_value)
print(min_value)
