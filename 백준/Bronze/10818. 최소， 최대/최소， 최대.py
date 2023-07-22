T = int(input())
numbers = list(map(int, input().split()))

max_check = -1000000
min_check = 1000000

for num in numbers:
    if num > max_check:
        max_check = num
    max_num = max_check

for num in numbers:
    if num < min_check:
        min_check = num

print(min_check, max_check)