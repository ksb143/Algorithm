from collections import Counter

def solution(participant, completion):
    # 참여자와 완주자 목록의 각각의 요소 수를 세기
    participant_counter = Counter(participant)
    completion_counter = Counter(completion)

    # 참여자 목록에서 완주자 목록을 뺀 차집합 구하기
    answer_counter = participant_counter - completion_counter

    # 남은 참여자 중 한 명이 완주하지 못한 사람
    answer = list(answer_counter.keys())[0]

    return answer
