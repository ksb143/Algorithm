def bfs(n, start, visited, computers):
    queue = [start]
    visited[start] = 1
    while queue:
        num = queue.pop(0)
        for i in range(n):
            if computers[num][i] == 1 and visited[i] == 0:
                queue.append(i)
                visited[i] = 1
    return visited


def solution(n, computers):
    visited = [0] * n
    cnt = 0
    while sum(visited) != n:
        for i in range(n):
            if visited[i] == 0:
                visited = bfs(n, i, visited, computers)
                cnt += 1
                break

    return cnt