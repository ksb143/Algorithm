import heapq

def solution(jobs):
    job_cnt = len(jobs)  # job 개수
    total_time = 0  # 총 대기 시간 + 작업 시간
    end, i = 0, 0  # 끝나는 시간, jobs 인덱스
    start = -1  # 시작 시간 초기화
    heap = []  # 우선 순위 큐

    jobs.sort()  # 시작 시간 기준으로 정렬
    
    while i < job_cnt or heap:
        # 현재 시간 이전에 시작한 모든 작업들을 힙에 추가
        for j in range(i, job_cnt):
            if start < jobs[j][0] <= end:
                heapq.heappush(heap, (jobs[j][1], jobs[j][0]))
                i += 1
            else:
                break

        # 힙에서 작업을 하나 꺼내 처리
        if heap:
            current_job = heapq.heappop(heap)
            start = end
            end += current_job[0]
            total_time += end - current_job[1]
        else:  # 현재 처리할 작업이 없다면, 다음 작업의 시작 시간으로 점프
            end = jobs[i][0]

    answer = total_time // job_cnt
    return answer
