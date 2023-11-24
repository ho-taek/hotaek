import sys
input = sys.stdin.readline
min = int(1e9)
n = int(input())
length = list(map(int, input().split()))
price = list(map(int, input().split()))
result = 0
for i in range(n-1):
    if price[i] < min:
        min = price[i]
    result += min * length[i]
  
    

print(result)