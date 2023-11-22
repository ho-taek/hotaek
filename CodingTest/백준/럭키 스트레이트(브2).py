n = list(map(int, input()))

length = len(n)
left = sum(n[0:(length//2)])
right = sum(n[(length//2) : length])
print(left, right)
if left == right:
    print("LUCKY")
else:
    print("READY")