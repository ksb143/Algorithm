N = int(input())  # 집 개수

red = [0] * N
green = [0] * N
blue = [0] * N

cost = []

for i in range(N):
    r, g, b = map(int, input().split())
    cost.append([r, g, b])

# 초기값 설정
dp = [[0] * 3 for _ in range(N)]
dp[0][0] = cost[0][0]
dp[0][1] = cost[0][1]
dp[0][2] = cost[0][2]

for i in range(1, N):
    for j in range(3):
        if j == 0:
            dp[i][j] = min(dp[i-1][1], dp[i-1][2]) + cost[i][j]
        elif j == 1:
            dp[i][j] = min(dp[i - 1][0], dp[i - 1][2]) + cost[i][j]
        else:
            dp[i][j] = min(dp[i - 1][0], dp[i - 1][1]) + cost[i][j]

print(min(dp[N-1]))