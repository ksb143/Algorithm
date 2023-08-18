def bfs(S):
    visited = [0] * 101
    queue = [0] * 10000
    front = rear = -1

    rear += 1
    queue[rear] = S
    visited[S] = 1

    while rear != front:
        front += 1
        node = queue[front]

        for n in range(101):
            if arr[node][n] == 1 and not visited[n]:
                rear += 1
                queue[rear] = n
                visited[n] = visited[node] + 1

    # 방문한 노드 중 가장 거리가 먼 것 중 큰 것 찾기
    last = 0
    for v in visited:
        if v > last:
            last = v
    max_idx = 0
    for idx in range(101):
        if last == visited[idx] and idx > max_idx:
            max_idx = idx
    return max_idx


for tc in range(1, 11):
    N, S = map(int, input().split())
    lst = list(map(int, input().split()))
    arr = [[0] * 101 for _ in range(101)]
    for i in range(0, N, 2):
        arr[lst[i]][lst[i+1]] = 1
    result = bfs(S)
    print(f'#{tc} {result}')

