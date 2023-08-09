def find_seven():
    # 9명의 리스트에 집어넣기
    lst = []
    for h in range(9):
        lst.append(int(input()))
    
    # 9명의 키 총합
    sum_nine = 0
    for n in lst:
        sum_nine += n

    # spy 두명 색출
    for i in range(len(lst)-1):
        for j in range(i+1, len(lst)):
            spy = lst[i] + lst[j]
            if sum_nine - spy == 100:
                lst.pop(j)
                lst.pop(i)
                return lst


lst = find_seven()

# 일곱난쟁이 정렬 (버블 정렬)
for i in range(6, 0, -1):
    for j in range(i):
        if lst[j] > lst[j+1]:
            lst[j], lst[j+1] = lst[j+1], lst[j]


# 출력
for s in lst:
    print(s)
