dr = [-1, 1, 0, 0]
dc = [0, 0, -1, 1]


def escape_maze(sr, sc):
    # 큐 생성
    queue = [0] * 100000
    # 큐의 f, r 생성
    front = rear = -1
    # 방문했던 곳 측정
    visited = [[0] * 16 for _ in range(16)]
    # 출발점 기록
    rear += 1
    queue[rear] = (sr, sc)
    visited[sr][sc] = 1

    # 큐가 텅 빌 때까지~!
    while front != rear:
        front += 1
        cr, cc = queue[front]
        # 탈출구 찾으면 함수 멈추고 리턴 1
        if maze[cr][cc] == 3:
            return 1

        for i in range(4):
            nr, nc = cr + dr[i], cc + dc[i]
            if 0 <= nr < 16 and 0 <= nc < 16 and\
                maze[nr][nc] != 1 and not visited[nr][nc]:
                rear += 1
                queue[rear] = (nr, nc)
                visited[nr][nc] = 1

    return 0


for tc in range(1, 11):
    N = int(input())
    maze = [list(map(int, input())) for _ in range(16)]
    for r in range(16):
        for c in range(16):
            if maze[r][c] == 2:
                sr, sc = r, c
    print(f'#{N} {escape_maze(sr, sc)}')

