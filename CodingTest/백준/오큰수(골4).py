import sys

input = sys.stdin.readline

n = int(input())
a = list(map(int, input().split()))

answer = [0]*n
stack = []

for i in range(n):
    while stack and a[stack[-1]] < a[i]:
        answer[stack.pop()] = a[i]
    stack.append(i)

while stack:
    answer[stack.pop()] = -1

result = ""

for i in range(n):
    result += str(a[i])+" "

print(result)
