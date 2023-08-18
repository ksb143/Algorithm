T = int(input())

for tc in range(1, T+1):
    max_fly = 0
    N, M = map(int, input().split())
    arr = []
    for _ in range(N):
        arr.append(list(map(int, input().split())))
    # 전체 격자 들리기 N-M+1 하는 이유는 N-M도 들리기 위해서
    for row in range(N-M+1):
        for col in range(N-M+1):
            cnt = 0
            # 파리가 때려지는 범위에 있는 파리 모두 더하기
            for fly_row in range(row, row+M):
                for fly_col in range(col, col+M):
                    cnt += arr[fly_row][fly_col]
            # 최대값 바꾸기
            if cnt > max_fly:
                max_fly = cnt
    print(f'#{tc} {max_fly}')
