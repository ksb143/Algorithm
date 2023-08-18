for _ in range(10):
    tc = int(input())
    arr = [list(map(int, input().split())) for _ in range(100)]
    max_num = 0
    # 가로 줄
    for row in range(0, 100):
        cnt = 0
        r_col = 0
        while r_col < 100:
            cnt += arr[row][r_col]
            r_col += 1
        if cnt > max_num:
            max_num = cnt
    # 세로줄
    for col in range(0, 100):
        cnt = 0
        c_row = 0
        while c_row < 100:
            cnt += arr[c_row][col]
            c_row += 1
        if cnt > max_num:
            max_num = cnt
    # 왼상 -> 우하 (r,c idx 같아도 순회 가능)
    present_r = 0
    present_c = 0
    cnt = 0
    for _ in range(100):
        cnt += arr[present_r][present_c]
        present_r += 1
        present_c += 1
    if cnt > max_num:
        max_num = cnt
    # 우상 -> 왼하 (ridx + cidx = 99면 순회 가능)
    present_r = 0
    present_c = 99
    cnt = 0
    for _ in range(100):
        cnt += arr[present_r][present_c]
        present_r += 1
        present_c -= 1
    if cnt > max_num:
        max_num = cnt
    print(f'#{tc} {max_num}')
    
# 중복되는 부분이 많으니 다 합칠 수도 있음