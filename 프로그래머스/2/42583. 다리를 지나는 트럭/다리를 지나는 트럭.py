from collections import deque

# 올리기 & 타기 1초, length 당 1초
def solution(bridge_length, weight, truck_weights):
    truck_weights = deque(truck_weights)  # 기존 트럭 deque로 바꾸기
    n = len(truck_weights)  # 총 트럭 개수

    current_time = 1  # 총 시간

    truck_queue = deque()  # 다리 위 트럭
    time_queue = deque()  # 다리 위 트럭 시간

    while truck_weights or truck_queue:
        # 트럭이 남아있고
        # 예상 길이 이하인 경우 & 예상 무게 이하
        if truck_weights and len(truck_queue) <= bridge_length - 1 and sum(truck_queue) + truck_weights[0] <= weight:
            truck_queue.append(truck_weights.popleft())
            time_queue.append(1)
        # 미리 간 차가 다리를 다 건넜는지 확인
        m = len(time_queue)
        comp = False
        for i in range(m):
            if time_queue[i] == bridge_length:
                comp = True
            else:
                time_queue[i] += 1
        # 다 건넜으면 하나 빼기
        if comp:
            truck_queue.popleft()
            time_queue.popleft()
        # 시간 증가
        current_time += 1
    return current_time