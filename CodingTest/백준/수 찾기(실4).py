import sys

input = sys.stdin.readline

n = int(input())
N = list(map(int, input().split()))
m = int(input())
M = list(map(int, input().split()))

set_n = set(N)
for i in M:
    if i in set_n:
        print(1)
    else:
        print(0)