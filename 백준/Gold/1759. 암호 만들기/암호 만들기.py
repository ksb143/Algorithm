def comb(idx, cnt, C, L, check):
    # 종료 조건
    if idx == C:
        # L개 뽑지 않았을 때 경우 넘기기
        if cnt != L:
            return
        # L개 뽑았을 경우
        word = ''
        for i in range(C):
            if check[i]:
                word += alpha[i]
        results.append(word)
        return

    check[idx] = 1
    cnt += 1
    comb(idx+1, cnt, C, L, check)
    check[idx] = 0
    cnt -= 1
    comb(idx+1, cnt, C, L, check)


L, C = map(int, input().split())

alpha = input().split()
alpha.sort()

check = [0] * C

results = []

comb(0, 0, C, L, check)

ans = []

for result in results:
    vow, con = 0, 0
    for i in result:
        if i in ['a', 'e', 'o', 'u', 'i']:
            vow += 1
        else:
            con += 1
    if vow >= 1 and con >= 2:
        ans.append(result)

print(*ans, sep='\n')
