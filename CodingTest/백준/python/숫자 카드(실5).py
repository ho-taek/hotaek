import sys

n = int(input())
N = list(map(int, input().split()))
m = int(input())
M = list(map(int, input().split()))

N.sort()


def binarySearch(array, target, start, end):
    while start <= end:
        mid = (start+end)//2
        if array[mid] == target:
            print(1 , end=' ')
            return
        elif array[mid] > target:
            end = mid-1
        else:
            start = mid + 1
    print(0, end=' ')
    return

for i in M:
    binarySearch(N,i,0,n-1)

