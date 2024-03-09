def perm(num, temp, visited, results):
    if len(temp) == num:
        results.append(temp[:])
    
    for i in range(num):
        if not visited[i]:
            temp.append(i)
            visited[i] = 1
            perm(num, temp, visited, results)
            temp.pop()
            visited[i] = 0
        


# k(유저 현재 피로도), dungeons(최소 필요 피로도, 소모 피로도)
def solution(k, dungeons):
    length = len(dungeons)
    temp = []
    results = []
    visited = [0] * length 
    
    perm(length, temp, visited, results)  # 갈 수 있는 모든 경우의 수 구하기
    
    answer = 0  # 갈 수 있는 최대 던전 구할 변수
    
    for result in results:
        curr_k = k
        cnt = 0
        for i in result:
            if curr_k >= dungeons[i][0]:
                curr_k -= dungeons[i][1]
                cnt += 1
        if cnt > answer:
            answer = cnt
    return answer