T = int(input())
for tc in range(1, T+1):
    N = int(input())
    arr = [list(map(int, input().split())) for _ in range(N)]
    print(f'#{tc}')
    for r in range(N):
        # 첫 번째 쭐
        for c in range(N-1, -1, -1):
            print(arr[c][r], end='')
        print(end=' ')
        # 두 번째 줄
        for c in range(N-1, -1, -1):
            print(arr[N-1-r][c], end='')
        print(end=' ')
        # 세 번째 줄
        for c in range(N):
            print(arr[c][N-r-1], end='')
        print()