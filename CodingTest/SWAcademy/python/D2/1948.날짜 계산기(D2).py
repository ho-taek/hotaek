T = int(input())
li = [0,31,59,90,120,151,181,212,243,273,304,334,365]
for t in range(1,T+1):
    a,b,c,d = map(int, input().split())
    value = (li[c-1]+d) - (li[a-1]+b) +1
    print("#%d"%t, value)