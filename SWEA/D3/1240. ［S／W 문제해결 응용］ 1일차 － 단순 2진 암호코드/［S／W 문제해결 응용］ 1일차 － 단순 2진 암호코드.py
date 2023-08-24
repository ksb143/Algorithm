# 1. 입력사이에서 (2진) 암호코드 찾아내기
# 2. (2진) 암호코드를 이루는 숫자 (10진수 암호코드) 찾아내기
# 3. (10진수) 암호코드가 정상인지 판단
# 4. 결과 출력

T = int(input())

dic = {'0001101':0, '0011001':1, '0010011':2, '0111101':3,\
       '0100011':4, '0110001':5, '0101111':6, '0111011':7,\
       '0110111':8, '0001011':9}

for tc in range(1, T+1):
    N, M = map(int, input().split())
    code_book = [list(map(int, input())) for _ in range(N)]
    for i in range(N):
        if 1 in code_book[i]:
            code_line = code_book[i]
            break
    # 끝에 코드 찾기
    for i in range(M-1, -1, -1):
        if code_line[i] == 1:
            idx = i
            break

    cnt = 0
    numbers = [0]*8
    # 코드에서 끊어읽기
    for i in range(idx - 55, idx + 1, 7):
        code = ''
        for j in range(i, i+7):
            code += str(code_line[j])
        numbers[cnt] = dic[code]
        cnt += 1
        # 코드 다 구하면 멈추기
        if cnt == 8:
            break

    # 맞는 암호코드인지 검사
    odd = 0
    even = 0
    for i in range(8):
        # 홀수면
        if i % 2 == 0:
            odd += numbers[i]
        # 짝수면
        else:
            even += numbers[i]
    check = odd * 3 + even

    # 합계
    result = 0
    for number in numbers:
        result += number

    if check % 10 == 0:
        print(f'#{tc} {result}')
    else:
        print(f'#{tc} {0}')


