# heaq 모듈 사용
import heapq

def solution(scovilles, K):
    # 힙구조로 바꿈
    heapq.heapify(scovilles)
    # 바꾸는 횟수 세는 변수
    cnt = 0
    # 스코빌 지수 높일 수 있으려면 최소 2이상의 음식이 있어야 함
    while len(scovilles) >= 2:
        # 맵지 않은 음식 꺼내기
        min_scov1 = heapq.heappop(scovilles)

        # 가장 맵지 않은 음식 스코빌 지수 K 이상일 때
        if min_scov1 >= K:
            break
        else:
            # 두 번재로 맵지 않은 음식 꺼내기
            min_scov2 = heapq.heappop(scovilles)
            new_scov = min_scov1 + (min_scov2 * 2)
            heapq.heappush(scovilles, new_scov)
            # 섞었으니 횟수 상승
            cnt += 1
    # 음식이 한 개 남아서 스코빌 지수 더 높일 수 없을 때
    else:
        last = heapq.heappop(scovilles)
        # 한 개 남은 음식이 원하는 스코빌 지수보다 작을 때
        if last < K:
            cnt = -1
    return cnt

print(solution([2, 3], 7))