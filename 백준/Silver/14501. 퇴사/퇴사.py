N = int(input())

plans = []

for i in range(N):
    T, P = map(int, input().split())
    plans.append((T, P))

max_profit = [0] * (N + 1)

for i in range(1, N + 1):
    for j in range(i):
        # 현재 상담을 진행할 수 있는 경우
        if j + plans[j][0] <= i:
            # 현재 상담을 선택했을 때와 선택하지 않았을 때의 최대 이익 비교
            max_profit[i] = max(max_profit[i], max_profit[j] + plans[j][1])

print(max_profit[N])