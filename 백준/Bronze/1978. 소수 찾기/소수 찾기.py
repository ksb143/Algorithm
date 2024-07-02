import math

n = int(input())
arr= list(map(int, input().split()))
cnt = 0
for num in arr:
    if num == 1:
        continue
    for i in range(2, int(math.sqrt(num)) + 1):
        if num % i == 0:
            break
    else:
        cnt += 1

print(cnt)