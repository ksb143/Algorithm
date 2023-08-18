T = int(input())

for tc in range(1, T+1):
    N = int(input())
    arr = list(map(int, input()))
    cnt = 0
    cnt_lst = []
    # 1이 연속하면 cnt를 계속 상승
    for i in arr:
        if i == 1:
            cnt += 1
            cnt_lst.append(cnt)
        # 0이 연속하면 cnt를 0로 초기화
        else:
            cnt = 0
    # cnt 중 가장 큰 숫자 찾음
    max_num = 0
    for j in cnt_lst:
        if j > max_num:
            max_num = j
    print(f'#{tc} {max_num}')

