def solution(citations):
    # 인용된 수 확인
    h = 0
    while True:
        cnt = 0
        for citation in citations:
            if citation >= h:
                cnt += 1
        if cnt >= h:
            h += 1
        else:
            h -= 1
            break
    return h