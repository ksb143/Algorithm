from collections import deque

def solution(priorities, location):
    n = len(priorities)
    queue = deque()
    for i in range(n):
        queue.append((priorities[i], i))
    cnt = 0
    while queue:
        pri, loc = queue.popleft()
        for rest_pri, rest_loc in queue:
            # queue에 남은 것 중에 우선순위가 더 높은게 있을 경우 break 및 다시 삽입
            if pri < rest_pri:
                queue.append((pri, loc))
                break
        else:
            cnt += 1
            if loc == location:
                answer = cnt
                break
    return answer