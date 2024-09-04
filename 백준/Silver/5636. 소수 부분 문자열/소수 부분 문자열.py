import math

# 소수 판별 함수
def is_prime(check):
    if check == 0:
        return False
    if check == 1:
        return False
    if check == 2:
        return True
    n = int(math.sqrt(check)) + 1
    for i in range(2, n):
        if (check % i == 0):
            return False
    return True

while True:
    number = input().strip()
    if number == '0':
        break
    ans = 0
    l = len(number)
    for i in range(l):
        for j in range(i, l):
            check = int(number[i:j+1])
            # 범위 넘어가면 커트
            if check > 100000:
                break
            if (is_prime(check)):
                ans = max(ans, check)
    print(ans)