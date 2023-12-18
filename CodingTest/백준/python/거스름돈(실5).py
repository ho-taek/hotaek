n = int(input())

div = n // 5
answer = int(1e9)
k = 0
while k <= div:
    a = n-k*5
    if a % 2 == 0 and a >= 0:
        answer = min(answer, k+(a//2))
    k += 1
if answer == int(1e9): 
    print(-1) 
else: 
    print(answer)



