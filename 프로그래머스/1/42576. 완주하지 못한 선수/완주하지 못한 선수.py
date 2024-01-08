def solution(participant, completion):
    # 완주 선수를 체크하기 위한 딕셔너리 생성
    check = dict()
    # 참여자 선수 반복문
    for par in participant:
        # 딕셔너리에 해당 선수 이름이 있으면 인원 추가
        if par in check:
            check[par] += 1
        # 딕셔너리에 해당 선수 이름이 없으면 해당 선수 이름 한명 추가
        else:
            check[par] = 1

    # 완주자 인원을 한명씩 제외
    for com in completion:
        check[com] -= 1

    # 모두 다 제외된 딕셔너리에 남은 인원 1인 있으면 그 인원이 완주 못한 사람
    for key, value in check.items():
        if value == 1:
            answer = key
    return answer
