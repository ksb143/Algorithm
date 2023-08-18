T = int(input())
for tc in range(1, T+1):
    N, M = map(int, input().split())
    arr = [list(map(int, input().split())) for _ in range(N)]
    max_length = 0
    # 행 조사
    for r in range(N):
        # 유물 길이 초기값
        length = 0
        for c in range(M):
            # 땅 끝일 경우
            if c == M-1:
                length += arr[r][c]
                if length > max_length:
                    max_length = length
            # 땅 끝이 아닌 경우
            else:
                # 유물이 측정될 경우
                if arr[r][c] == 1:
                    length += arr[r][c]
                # 유물의 길이가 끝난 경우
                else:
                    if length > max_length:
                        max_length = length
                    length = 0
    # 열 조사
    for r in range(M):
        # 유물 길이 초기값
        length = 0
        for c in range(N):
            # 땅 끝일 경우
            if c == N-1:
                length += arr[c][r]
                if length > max_length:
                    max_length = length
            # 땅 끝이 아닌 경우
            else:
                # 유물이 측정될 경우
                if arr[c][r] == 1:
                    length += arr[c][r]
                # 유물의 길이가 끝난 경우
                else:
                    if length > max_length:
                        max_length = length
                    length = 0
    print(f'#{tc} {max_length}')
