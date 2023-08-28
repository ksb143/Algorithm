def solve(N):
    for i in range(0, N, 3):
        num = int(cards[i+1]+cards[i+2])
        if cards[i] == 'S':
            if deck[0][num] == 0:
                deck[0][num] = 1
            else:
                return 'ERROR'
        if cards[i] == 'D':
            if deck[1][num] == 0:
                deck[1][num] = 1
            else:
                return 'ERROR'
        if cards[i] == 'H':
            if deck[2][num] == 0:
                deck[2][num] = 1
            else:
                return 'ERROR'
        if cards[i] == 'C':
            if deck[3][num] == 0:
                deck[3][num] = 1
            else:
                return 'ERROR'
    # 리스트가 0부터 시작하므로 -1로 시작
    needs = [-1] * 4
    for i in range(4):
        for j in deck[i]:
            if j == 0:
                needs[i] += 1
    return needs


T = int(input())

for tc in range(1, T+1):
    cards = input()
    N = len(cards)
    deck = [[0] * 14 for _ in range(4)]
    result = solve(N)
    if type(result) == list:
        print(f'#{tc}', *result)
    else:
        print(f'#{tc} {result}')



