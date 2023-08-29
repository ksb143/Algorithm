def check(binary, trinary):
    N, M = len(binary), len(trinary)
    # 2진수 숫자 하나씩 바꿔주기
    for i in range(N):
        if binary[i] == '0':
            temp1 = binary[:i] + '1' + binary[i+1:]
        else:
            temp1 = binary[:i] + '0' + binary[i+1:]
        temp_b = 0
        # 2진수를 10진수로 바꾸는 반복문
        for b in range(N):
            temp_b = temp_b * 2 + int(temp1[b])
        # 3진수 숫자 하나씩 바꿔주기
        for j in range(M):
            if trinary[j] == '0':
                temp2 = trinary[:j] + '1' + trinary[j+1:]
                temp_t = 0
                # 3진수를 10진수로 바꾸는 반복문
                for t in range(M):
                    temp_t = temp_t * 3 + int(temp2[t])
                if temp_t == temp_b:
                    return temp_t
                temp2 = trinary[:j] + '2' + trinary[j+1:]
                temp_t = 0
                # 3진수를 10진수로 바꾸는 반복문
                for t in range(M):
                    temp_t = temp_t * 3 + int(temp2[t])
                if temp_t == temp_b:
                    return temp_t
            elif trinary[j] == '1':
                temp2 = trinary[:j] + '0' + trinary[j+1:]
                temp_t = 0
                # 3진수를 10진수로 바꾸는 반복문
                for t in range(M):
                    temp_t = temp_t * 3 + int(temp2[t])
                if temp_t == temp_b:
                    return temp_t
                temp2 = trinary[:j] + '2' + trinary[j+1:]
                temp_t = 0
                # 3진수를 10진수로 바꾸는 반복문
                for t in range(M):
                    temp_t = temp_t * 3 + int(temp2[t])
                if temp_t == temp_b:
                    return temp_t
            else:
                temp2 = trinary[:j] + '0' + trinary[j+1:]
                temp_t = 0
                # 3진수를 10진수로 바꾸는 반복문
                for t in range(M):
                    temp_t = temp_t * 3 + int(temp2[t])
                if temp_t == temp_b:
                    return temp_t
                temp2 = trinary[:j] + '1' + trinary[j+1:]
                temp_t = 0
                # 3진수를 10진수로 바꾸는 반복문
                for t in range(M):
                    temp_t = temp_t * 3 + int(temp2[t])
                if temp_t == temp_b:
                    return temp_t


T = int(input())
for tc in range(1, T+1):
    binary = input()
    trinary = input()
    result = check(binary, trinary)
    print(f'#{tc} {result}')
