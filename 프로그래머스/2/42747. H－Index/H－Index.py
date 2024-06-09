def solution(citations):
    # 인용 횟수 내림차순
    citations.sort(reverse = True)
    # 총 논문 개수
    n = len(citations)
    
    h_index = 0
    
    for i in range(n):
        # 인용 횟수가 순위보다 크거나 같으면 h_index 증가
        if citations[i] >= i + 1:
            h_index = i + 1
        else:
            break
    return h_index