T = int(input())
# 상하 좌우 이동할 수 있는 이동 좌표값
di = [-1, 0, 1, 0]
dj = [0, 1, 0, -1]

for tc in range(1, 1+T):
    N, M = map(int, input().split())
    arr = []
    for _ in range(N):
        arr.append(list(map(int, input().split())))
    # 최대값 0으로 지정
    max_num = 0
    for i in range(N):
        for j in range(M):
            # 본인 값 더하기
            sum_arr = arr[i][j]
            # 꽃가루 있는 상, 하, 좌, 우 값 더하기
            for d in range(4):
                ni = i + di[d]
                nj = j + dj[d]
                # 단 범위 내에 있어야 더하기
                if 0 <= ni < N and 0 <= nj < M:
                    sum_arr += arr[ni][nj]
            # sum_arr 계산했을 때 기존 최대값보다 크면 바꾸기
            if max_num < sum_arr:
                max_num = sum_arr
    # 반복문 모두 돈 다음 최대값 출력
    print(f'#{tc} {max_num}')

