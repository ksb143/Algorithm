def solution(citations):
    # 인용된 수로 정렬
    citations.sort(reverse = True)
    n = len(citations)
    for i in range(n):
        if citations[i] <= i:
            return i
    # 모두가 인용됐을 경우
    return n