# 주어진 숫자의 모든 약수를 찾는 함수
# n의 제곱근(√n)까지만 검사하면, 더 적은 계산으로 모든 약수를 찾을 수 있습니다.
def get_divisors(n):
    divisors = set()  # 약수를 저장할 집합, 중복을 방지하기 위해 집합 사용
    for i in range(1, int(n**0.5) + 1): # 1부터 n의 제곱근까지 반복
        if n % i == 0: # i가 n의 약수인 경우
            divisors.add(i) # i를 약수 집합에 추가
            divisors.add(n // i) # n을 i로 나눈 몫도 약수이므로 추가
    return divisors

def solution(arrayA, arrayB):
    # arrayA와 arrayB의 최소값의 약수
    divisorsA = get_divisors(min(arrayA))
    divisorsB = get_divisors(min(arrayB))
    
    max_a = 0 # 구할 값
    # 나눠지는지 확인 (all은 값이 참이어야지 참, any는 하나라도 참이면 참)
    for d in divisorsA:
        if all(a % d == 0 for a in arrayA) and not any(b % d == 0 for b in arrayB):
            max_a = max(max_a, d)
            
    for d in divisorsB:
        if all(b % d == 0 for b in arrayB) and not any(a % d == 0 for a in arrayA):
            max_a = max(max_a, d)
            
    return max_a