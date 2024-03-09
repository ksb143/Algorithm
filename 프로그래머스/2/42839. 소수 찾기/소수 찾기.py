import math

# 순열 만들기 함수 (재귀)
def make_perm(numbers, temp, visited, result):
    # 기저 조건
    if len(temp) > 0:
        num = int(''.join(temp))
        # 소수 여부 및 중복 판단
        if num > 1 and is_prime(num) and num not in result:
            result.append(num)
    for i in range(len(numbers)):
        # 상태변화
        if not visited[i]:
            visited[i] = True
            temp.append(numbers[i])
             # 재귀 호출
            make_perm(numbers, temp, visited, result)
            # 원복
            temp.pop()
            visited[i] = False

# 소수 판단 함수
def is_prime(number):
    check_number = int(math.sqrt(number))
    
    for num in range(2, check_number + 1):
        # 나누어지면 소수 아님
        if number % num == 0:
            return False
    else:
        return True    


def solution(numbers):
    result = []
    temp = []
    visited = [False] * len(numbers)
    make_perm(numbers, temp, visited, result)
    
    return len(result)