N = int(input())

plans = []

for i in range(N):
    T, P = map(int, input().split())
    plans.append((T, P))

max_profit = [0] * (N + 1)

# 역순 진행
for i in range(N - 1, -1, -1):
    # 현재 상담이 퇴사 전까지 완료할 수 있는 경우
    if i + plans[i][0] <= N:
        # 현재 상담 할 경우와 안 할 경우 비교
        max_profit[i] = max(plans[i][1] + max_profit[i + plans[i][0]], max_profit[i + 1])
    # 현재 상담이 퇴사 전까지 완료할 수 없는 경우
    else:
        max_profit[i] = max_profit[i + 1]

print(max_profit[0])
