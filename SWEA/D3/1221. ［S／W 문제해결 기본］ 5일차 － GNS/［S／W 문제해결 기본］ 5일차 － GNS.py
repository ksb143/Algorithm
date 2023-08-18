T = int(input())
for _ in range(T):
    tc, num = input().split()
    lst = input().split()
    # 카운트 배열 만들기
    num_lst = [0] * 10
    # 카운트 배열 세고 카운트 배열 세기 위해 int형으로 바꾸기
    for i in range(int(num)):
        if lst[i] == 'ZRO':
            num_lst[0] += 1
            lst[i] = 0
        elif lst[i] == 'ONE':
            num_lst[1] += 1
            lst[i] = 1
        elif lst[i] == 'TWO':
            num_lst[2] += 1
            lst[i] = 2
        elif lst[i] == 'THR':
            num_lst[3] += 1
            lst[i] = 3
        elif lst[i] == 'FOR':
            num_lst[4] += 1
            lst[i] = 4
        elif lst[i] == 'FIV':
            num_lst[5] += 1
            lst[i] = 5
        elif lst[i] == 'SIX':
            num_lst[6] += 1
            lst[i] = 6
        elif lst[i] == 'SVN':
            num_lst[7] += 1
            lst[i] = 7
        elif lst[i] == 'EGT':
            num_lst[8] += 1
            lst[i] = 8
        else:
            num_lst[9] += 1
            lst[i] = 9

    # 카운트 배열 누적 쌓기
    for i in range(1, len(num_lst)):
        num_lst[i] += num_lst[i-1]

    # 카운트 배열 이용하여 정렬된 배열에 넣기
    sorted_lst = [0] * int(num)
    for i in range(int(num)):
        # lst[i]가 들어갈 위치
        num_lst[lst[i]] -= 1  # lst[i] 요소가 들어갈 위치
        sorted_lst[num_lst[lst[i]]] = lst[i]

    # 정렬된 배열 원래 형식으로 바꾸기
    for i in range(int(num)):
        if sorted_lst[i] == 0:
            lst[i] = 'ZRO'
        elif sorted_lst[i] == 1:
            lst[i] = 'ONE'
        elif sorted_lst[i] == 2:
            lst[i] = 'TWO'
        elif sorted_lst[i] == 3:
            lst[i] = 'THR'
        elif sorted_lst[i] == 4:
            lst[i] = 'FOR'
        elif sorted_lst[i] == 5:
            lst[i] = 'FIV'
        elif sorted_lst[i] == 6:
            lst[i] = 'SIX'
        elif sorted_lst[i] == 7:
            lst[i] = 'SVN'
        elif sorted_lst[i] == 8:
            lst[i] = 'EGT'
        else:
            lst[i] = 'NIN'
    print(tc)
    print(*lst)

