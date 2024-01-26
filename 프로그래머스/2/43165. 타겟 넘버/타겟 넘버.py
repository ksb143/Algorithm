from collections import deque


def solution(numbers, target):
    # 길이
    N = len(numbers)

    # 초기상태 만들기
    queue = deque()
    queue.append((0, 0))

    # 타겟 넘버로 만들어진 카운트
    cnt = 0

    while queue:
        # num, idx 꺼내기
        num, idx = queue.pop()
        # idx가 N이고 그게 타겟 넘버와 같으면 cnt 증가 후 continue
        if idx == N and num == target:
            cnt += 1
            continue
        # idx가 그냥 N이면 continue
        elif idx == N:
            continue
        # 나머지 경우에는 숫자를 계속 삽입하기
        queue.append((num + numbers[idx], idx + 1))
        queue.append((num - numbers[idx], idx + 1))

    return cnt