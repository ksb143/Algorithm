import heapq

def solution(jobs):
    job_cnt = len(jobs) # job 개수
    total_time = 0 # 총 대기 시간
    start, end, i = -1, 0, 0 # 이전 작업, 현재 시간, 처리 작업수
    heap = [] # 우선순위 큐
    
    jobs.sort() # 시작 시간 기준 정렬
    
    while i < job_cnt:
        # 현재 시간 이전에 시작한 모든 작업 힙에 추가
        for job in jobs:
            if start < job[0] <= end:
                heapq.heappush(heap, (job[1], job[0]))
                
        if heap:
            current_job = heapq.heappop(heap)
            start = end
            end += current_job[0]
            total_time += end - current_job[1]
            i += 1
        else:
            end += 1
            
    answer = total_time // job_cnt
    return answer
