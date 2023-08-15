A, B = input().split()

# 최대 합으로 바꾸기
max_a = ''
for i in A:
    if i == '5':
        i = '6'
    max_a += i
max_a = int(max_a)
max_b = ''
for i in B:
    if i == '5':
        i = '6'
    max_b += i
max_b = int(max_b)

max_sum = max_a + max_b

# 최소 합으로 바꾸기
min_a = ''
for i in A:
    if i == '6':
        i = '5'
    min_a += i
min_a = int(min_a)
min_b = ''
for i in B:
    if i == '6':
        i = '5'
    min_b += i
min_b = int(min_b)

min_sum = min_a + min_b

print(min_sum, max_sum)