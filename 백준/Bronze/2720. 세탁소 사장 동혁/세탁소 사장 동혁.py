T = int(input())

# 코인 종류
coins = [25, 10, 5, 1]
# 거스름돈 개수 
coin_num = 0

# tc 동안 input 받기
for tc in range(T):
    c = int(input())
    # 제일 큰 거스름돈부터 세기 (greedy)
    for coin in coins:
        charge = c // coin
        # 뒤에 공백을 위해서 end = ' '
        print(charge, end=' ')
        # 남은 거스름돈
        c = c % coin
    # 다음 tc일 때 넘어 enter 되도록 하기
    if tc != T-1:
        print()
