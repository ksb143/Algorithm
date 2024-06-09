# 앞에 글자가 가장 큰 수를 처음에 넣기
def solution(numbers):
    numbers = list(map(str, numbers))
    # 1000까지 해당하니까 4자리수까지 포함
    numbers.sort(key=lambda x: x * 4, reverse=True)
    answer = str(int(''.join(numbers)))
    return answer