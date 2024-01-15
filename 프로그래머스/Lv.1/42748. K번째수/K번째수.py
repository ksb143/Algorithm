# array 뽑아낼 배열
# commands i, j, k 원소 가진 2차원 배열
def solution(array, commands):
    # 코멘드 길이
    len_comm = len(commands)

    # answer을 담을 배열
    answer = []

    for idx in range(len_comm):
        # 코멘드에서 i, j, k 뽑기
        i, j, k = commands[idx][0], commands[idx][1], commands[idx][2]
        # i부터 j까지 배열만 뽑기 (슬라이싱 이용)
        new_arr = array[i-1:j]
        # 뽑은 배열 정렬
        new_arr.sort()
        # k 번째 뽑고 바로 삽입
        answer.append(new_arr[k-1])
    return answer