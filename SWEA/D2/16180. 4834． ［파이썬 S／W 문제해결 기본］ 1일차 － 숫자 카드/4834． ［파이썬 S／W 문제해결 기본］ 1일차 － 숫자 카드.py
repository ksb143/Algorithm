T = int(input())
for tc in range(1, T+1):
    N = int(input())
    cards = list(map(int, input()))
    # 빈 인덱스 리스트 만들기
    card_idx = [0] * 10
    # 해당 번호 인덱스에 +1 추가 하기
    for i in range(N):
        card_idx[cards[i]] += 1
    # 가장 많은 카드(인덱스) 및 그 카드 수량(요소) 구하기
    max_num_card_idx = 0
    max_num_card = card_idx[0]
    for j in range(1, 10):
        if card_idx[j] >= max_num_card:
            max_num_card_idx = j
            max_num_card = card_idx[j]
    print(f'#{tc} {max_num_card_idx} {max_num_card}')
