from collections import deque

N, K = map(int, input().split())

visited = [0] * 100001

def bfs(position, visited):
    queue = deque([(N, 0)])
    while True:
        position, cnt = queue.popleft()
        visited[position] = 1
        if position == K:
            return cnt
        forward, back, teleport = position + 1, position - 1, position * 2
        # 방문 하지 않았을 경우 앞으로 이동
        if 0 <= forward <= 100000 and visited[forward] == 0:
            queue.append((forward, cnt + 1))
        # 방문 하지 않았을 경우 뒤로 이동
        if 0 <= back <= 100000 and visited[back] == 0:
            queue.append((back, cnt + 1))
        # 방문 하지 않았을 경우 2배 앞으로 이동
        if 0 <= teleport <= 100000 and visited[teleport] == 0:
            queue.append((teleport, cnt + 1))

answer = bfs(N, visited)
print(answer)