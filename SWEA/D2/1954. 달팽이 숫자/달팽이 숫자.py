T = int(input())
# 우, 하, 좌, 상
dr = [0, 1, 0, -1]
dc = [1, 0, -1, 0]

for tc in range(1, T+1):
    N = int(input())
    arr = [[0]*N for _ in range(N)]
    # 최초 시작 인덱스
    r, c = 0, 0
    # 달팽이 안에 들어갈 숫자
    num = 1
    # direct index (최초 : 오른쪽으로 향함)
    direct = 0
    # 기본 넘버는 N*N를 넘어갈 수 없기 때문에 num이 N*N이 될 때까지 반복
    while num <= N*N:
        # 해당 인덱스에 num 삽입
        arr[r][c] = num
        # 그 다음 num으로 증가
        num += 1
        # 다음 인덱스로 이동
        r += dr[direct]
        c += dc[direct]
        # 범위에서 벗어났는지 확인(우선 확인)
        if 0 > c or c >= N or 0 > r or r >= N:
            # 벗어난 범위에서 다시 돌아오기
            r -= dr[direct]
            c -= dc[direct]
            # 범위 벗어났으니 방향 바꾸기
            direct = (direct + 1) % 4
            # 다음 인덱스로 이동
            r += dr[direct]
            c += dc[direct]
        # 범위내에 있지만 이동한 위치에 이미 값이 있는지 확인 (두번째 확인)
        elif arr[r][c] != 0:
            # 다시 돌아오기
            r -= dr[direct]
            c -= dc[direct]
            # 방향 바꾸기
            direct = (direct + 1) % 4
            # 다음 인덱스로 이동
            r += dr[direct]
            c += dc[direct]
    # 처음에 row + arr[r][c](기존값 유무), col + arr[r][c](기존값 유무) 따로 조사
    # 이랬더니 row 안 벗어나면 col 검사로 넘어가야하는데 row 검사할 때 arr[r][c]가 out of range 확인이 불가능해 error
    # if, elif로 분리하니 기존에 범위 벗어났는지 먼저 검사 후 값이 있는지 검사하기 때문에 error 안 뜸
    print(f'#{tc}')
    for i in arr:
        print(*i[:])





