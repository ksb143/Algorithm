# 좌, 상, 우
dr = [0, -1, 0]
dc = [-1, 0, 1]

for tc in range(10):
    t = int(input())
    ladder = [list(map(int, input().split())) for _ in range(100)]
    # x 위치 구하기
    for c in range(100):
        if ladder[99][c] == 2:
            boom = c
    # 오, 왼 간 것 초기화
    right = False
    left = False
    r, c = 99, boom
    # r이 0보다 클 때까지 이동
    while r > 0:
        # 왼쪽이 범위 내고 1이 있으면서 이전 작업이 오른쪽으로 간 것이 아니면 왼쪽으로 이동
        if (0 <= (c + dc[0]) < 100) and (ladder[r + dr[0]][c + dc[0]] == 1) and (right == False):
            c = c + dc[0]
            # 왼쪽 갔으니 오른쪽으로 True 변경, 오른쪽은 False
            left = True
            right = False
        # 오른쪽이 범위 내고 1이 있으면서 이전 작업이 왼쪽으로 간 것이 아니면 오른쪽으로 이동
        elif (0 <= (c + dc[2]) < 100) and (ladder[r + dr[2]][c + dc[2]] == 1) and (left == False):
            c = c + dc[2]
            # 오른쪽 갔으니 오른쪽으로 True 변경, 왼쪽은 False
            right = True
            left = False
        # 그밖의 경우는 위가 1이므로 위로 이동하고 왼쪽, 오른쪽 간 것은 초기화
        else:
            r = r + dr[1]
            right = False
            left = False
    print(f'#{t} {c}')




