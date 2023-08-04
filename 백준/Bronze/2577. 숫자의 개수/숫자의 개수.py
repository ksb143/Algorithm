nums = 1
for i in range(3):
    nums *= int(input())

dic = {}

# dictionary key 값 받기
for num_check in range(10):
    # key 값에 맞는 value 값 초기화
    cnt = 0
    # key 값과 똑같은 value 나올 때마다 +1
    for num in str(nums):
        if num == str(num_check):
            cnt += 1
    # value cnt 할당
    dic[num_check] = cnt
lst = dic.values()
print(*lst, sep='\n')

