def pascal(N, arr):
    for r in range(1, N):
        for c in range(N):
            if c - 1 < 0:
                arr[r][c] = arr[r - 1][c]
            else:
                arr[r][c] = arr[r - 1][c - 1] + arr[r - 1][c]
    return arr


T = int(input())
for tc in range(1, T+1):
    N = int(input())
    arr = [[0] * N for _ in range(N)]
    arr[0][0] = 1
    arr = pascal(N, arr)

    print(f'#{tc}')
    for i in range(N):
        for j in range(N):
            if arr[i][j] != 0:
                print(arr[i][j], end=' ')
        print()