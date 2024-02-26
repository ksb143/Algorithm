import math

def is_prime(n):
    # 아무 수도 없을 경우 
    if n == '':
        return False
    # 수가 1인 경우
    n = int(n)
    if n <= 1:
        return False
    # 수가 나눠질 경우
    # n=a×b 형태로 나타낼 수 있으며, a와 b 중 적어도 하나는 n의 제곱근보다 작거나 같다 (명심)
    for i in range(2, int(math.sqrt(n)) + 1):
        if n % i == 0:
            return False
    # 모두 아닌 경우
    return True

def solution(n, k):
    numbers = ''
    # k진수로 만들기
    while n > 0:
        n, mod = divmod(n, k) # 몫과 나머지를 반환
        numbers += str(mod)
    numbers = numbers[::-1] # 뒤집기
    cnt = 0
    check_num = ''
    # 소수 여부 판단
    for num in numbers:
        if num == '0':
            # 소수인지 판단
            if is_prime(check_num):
                cnt += 1
            # 초기화
            check_num = ''
        else:
            check_num += num
    # 마지막 수 소수인지 판단
    if is_prime(check_num):
        cnt += 1
    return cnt