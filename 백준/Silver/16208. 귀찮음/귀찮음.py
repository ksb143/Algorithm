N = int(input())
sticks = sorted(list(map(int, input().split())))

stick_length = sum(sticks)
cost = 0
# 마지막 막대기는 계산해주지 않아도 되므로 N-1까지만 계산
for i in range(N-1):
    stick_length -= sticks[i]
    cost += sticks[i]*stick_length
print(cost)
