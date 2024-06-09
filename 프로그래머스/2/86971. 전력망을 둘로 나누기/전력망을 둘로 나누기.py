from collections import defaultdict

def bfs(x, y, n, connect_info):
    visited = [0] * (n + 1)
    visited[x] = 1
    queue = [x]
    cnt = 1
    while queue:
        curr = queue.pop(0)
        for num in connect_info[curr]:
            # 방문한 적 없고 끊은 숫자가 아닌 경우
            if visited[num] == 0 and num != y:
                queue.append(num)
                visited[num] = 1
                cnt += 1
    return cnt

def solution(n, wires):
    # 연결된 전선 정보 저장
    connect_info = defaultdict(list)
    for x, y in wires:
        connect_info[x].append(y)
        connect_info[y].append(x)
    answer = 100
    # 하나씩 끊어보고 탐색 하기
    for x, y in wires:
        value1 = bfs(x, y, n, connect_info)
        value2 = n - value1
        value = abs(value1 - value2)
        if value < answer:
            answer = value 
    return answer