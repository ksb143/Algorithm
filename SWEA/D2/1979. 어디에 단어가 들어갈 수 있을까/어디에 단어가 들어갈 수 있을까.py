T = int(input())

for tc in range(1, T+1):
    N, K = map(int, input().split())
    arr = [list(map(int, input().split())) for _ in range(N)]
    # 행열 검증 연속된 1이 K와 같으면 word +1
    word = 0
    # 행 읽기
    for r in range(N):
        cnt = 0
        for c in range(N):
            if arr[r][c] == 1:
                cnt += arr[r][c]
            # 숫자가 0일 때 cnt 숫자가 k와 같으면 word 올리기, cnt은 0으로 초기화
            if arr[r][c] == 0 or c == (N-1):
                if cnt == K:
                    word += 1
                cnt = 0
    # 열 읽기
    for c in range(N):
        cnt = 0
        for r in range(N):
            if arr[r][c] == 1:
                cnt += arr[r][c]
            # 숫자가 0일 때 cnt 숫자가 k와 같으면 word 올리기, cnt은 0으로 초기화
            if arr[r][c] == 0 or r == (N-1):
                if cnt == K:
                    word += 1
                cnt = 0
    print(f'#{tc} {word}')

