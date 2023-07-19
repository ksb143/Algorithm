common_factor = list(map(int, input().split()))
lst = []

for i in range(1, common_factor[0]+1):
    if common_factor[0] % i == 0:
        lst.append(i)
if len(lst) >= common_factor[1]:
    print(lst[common_factor[1]-1])
else:
    print(0)