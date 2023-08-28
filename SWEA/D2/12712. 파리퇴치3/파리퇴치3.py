T = int(input())

for tc in range(1, T+1):
    N, M = map(int, input().split())
    arr = [list(map(int, input().split())) for _ in range(N)]

    # 최대 파리 수
    max_v = 0
    for i in range(N):
        # 스프레이 뿌릴 위치
        for j in range(N):
            # + 방향
            s = arr[i][j]
            for di, dj in [[0, 1], [1, 0], [0, -1], [-1, 0]]:
                for k in range(1, M):
                    ni, nj = i + di*k, j + dj*k
                    if 0 <= ni < N and 0 <= nj < N:
                        s += arr[ni][nj]
            if max_v < s:
                max_v = s
            # x 방향
            s = arr[i][j]
            for di, dj in [[1, 1], [1, -1], [-1, -1], [-1, 1]]:
                for k in range(1, M):
                    ni, nj = i + di*k, j + dj*k
                    if 0 <= ni < N and 0 <= nj < N:
                        s += arr[ni][nj]
            if max_v < s:
                max_v = s

    print(f'#{tc} {max_v}')