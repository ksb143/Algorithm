code_dic = {
    (3,2,1,1) : 0,
    (2,2,2,1) : 1,
    (2,1,2,2) : 2,
    (1,4,1,1) : 3,
    (1,1,3,2) : 4,
    (1,2,3,1) : 5,
    (1,1,1,4) : 6,
    (1,3,1,2) : 7,
    (1,2,1,3) : 8,
    (3,1,1,2) : 9
}

# 16진수 10진수로 바꾸기
def decimal(h):
    return int(h, base=16)


# 10진수 2진수로 바꾸기
def binary(d):
    b = []
    while d >= 2:
        b.insert(0, d % 2)
        d //= 2
    b.insert(0, d)
    result = b
    if len(b) == 1:
        result = [0, 0, 0]
        result.extend(b)
    elif len(b) == 2:
        result = [0, 0]
        result.extend(b)
    elif len(b) == 3:
        result = [0]
        result.extend(b)
    return result


# 전체 코드 이진수로 바꿔주기
def bin_code(data):
    for i in range(N):
        lst = []
        for j in range(M):
            lst.extend(binary(decimal(data[i][j])))
        mat.append(lst)
    return len(mat[0])


T = int(input())

for tc in range(1, T+1):
    # 세로, 가로 크기
    N, M = map(int, input().split())
    data = [input() for _ in range(N)]
    # 이진수로 바꿔줄 2차원 배열
    mat = []
    # 이진수로 바꾼 코드의 m 끝 idx를 구하기
    m = bin_code(data)
    # 중복 제외하기지
    duple = set()
    # 해당 합
    secret_num = 0
    for i in range(N):
        # for j in range(new_m - 1, -1, -1):
        j = m
        while j != -1:
            j -= 1
            # 끝자리가 1이면 해당 암호 구하기
            if mat[i][j] == 1:
                code = [0] * 8
                idx = 0
                for _ in range(8):
                    # 숫자 1개 읽어오기
                    w1 = w2 = w3 = w4 = 0
                    while mat[i][j] == 1:
                        w4 += 1
                        j -= 1
                    # 0의 개수 세기
                    while mat[i][j] == 0:
                        w3 += 1
                        j -= 1
                    # 1의 개수 세기
                    while mat[i][j] == 1:
                        w2 += 1
                        j -= 1
                    # 비율 및 마지막 꺼 개수 구하기
                    mini = w4
                    for x in [w4, w3, w2]:
                        if x < mini:
                            mini = x
                    ratio2 = w2 // mini
                    ratio3 = w3 // mini
                    ratio4 = w4 // mini
                    ratio1 = 7 - (ratio2 + ratio3 + ratio4)
                    w1 = ratio1 * mini
                    j -= w1
                    code[idx] = code_dic[(ratio1, ratio2, ratio3, ratio4)]
                    idx += 1
                # 중복 체크
                code_ck = tuple(code)
                if code_ck in duple:
                    continue
                duple.add(code_ck)
                # 암호코드(code) 정상인지 아닌지 판별
                odd_s = code[1] + code[3] + code[5] + code[7]
                even_s = code[0] + code[2] + code[4] + code[6]
                if ((odd_s * 3) + even_s) % 10 == 0:
                    secret_num += odd_s + even_s
    print(f'#{tc} {secret_num}')

