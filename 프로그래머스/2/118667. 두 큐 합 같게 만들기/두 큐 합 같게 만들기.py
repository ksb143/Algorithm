from collections import deque

def solution(queue1, queue2):
    # 전체 요소 
    total_queue = queue1 + queue2
    # 속도를 위해 deque로 데이터 형태 변환
    queue1, queue2 = deque(queue1), deque(queue2)
    # 하나의 값인 경우 바로 return -1
    # 둘의 값이 홀수면 소용 없으니까 바로 return -1을 함
    if (sum(total_queue) % 2 == 1):
        return -1
    # 둘의 값이 같아야 하므로 반을 구함
    half = (sum(queue1) + sum(queue2)) // 2
    cnt = 0
    first_queue1 = sum(queue1)
    first_queue2 = sum(queue2)
    switch_length = len(total_queue)
    # 같을 때 까지 돌리기 
    while first_queue1 != first_queue2:
        if first_queue1 > first_queue2:
            value = queue1.popleft()
            queue2.append(value)
            first_queue1 -= value
            first_queue2 += value
        else:
            value = queue2.popleft()
            queue1.append(value)
            first_queue2 -= value
            first_queue1 += value
        # 처음으로 돌아가면 break하고 끝내버리기
        if cnt >= switch_length * 2:
            cnt = -1
            break
        cnt += 1
    return cnt