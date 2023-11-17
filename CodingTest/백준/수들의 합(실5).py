s = int(input())

result,tmp = 0,0

    

for i in range(1,s+1):
    tmp += i
    if tmp > s:
        break
    else:
        result += 1
print(result)