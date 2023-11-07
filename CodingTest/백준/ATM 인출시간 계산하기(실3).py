import sys

input = sys.stdin.readline

n = int(input())
a = list(map(int, input().split()))


for i in range(1,n):
    insert_point = i
    insert_value = a[i]

    for j in range(i-1, -1, -1):
        if a[j] < a[i]:
            insert_point = j+1
            break
        if j == 0:
            insert_point = 0
    for j in range(i, insert_point, -1):
        a[j] = a[j-1]
    a[insert_point] = insert_value


ans = 0
for i in range(1,n+1):
    ans += sum(a[:i])
    

print(ans)
