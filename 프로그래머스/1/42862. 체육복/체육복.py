def solution(n, lost, reserve):
    # 여분을 들고온 학생꺼는 돌려주기 (세트 차집합 이용)
    lost_set = set(lost)
    res_set = set(reserve)
    reserve = list(res_set - lost_set)
    lost = list(lost_set - res_set)
    # 안들고 온 학생 빼기
    n = n - len(lost)
    for res in reserve:
        # 작은 것부터 앞 뒤로 빌려줄 수 있는지 확인 후
        # 빌려줄 수 있다면 전체 학생수에서 +
        if res-1 in lost:
            n += 1
            lost.remove(res - 1)
        elif res in lost:
            n += 1
            lost.remove(res)
        elif res+1 in lost:
            n += 1
            lost.remove(res + 1)
    answer = n
    return answer