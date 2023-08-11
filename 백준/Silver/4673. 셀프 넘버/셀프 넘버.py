lst = []

for i in range(1, 10001):
    num = i
    for j in str(num):
        num += int(j)
    lst.append(num)

for i in range(1, 10001):
    for j in lst:
        if i == j:
            break
    else:
        print(i)