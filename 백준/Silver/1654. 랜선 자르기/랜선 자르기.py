# 랜선 개수 K, 필요한 랜선 개수 N
K, N = map(int, input().split())
cables = []
for _ in range(K):
    cables.append(int(input()))

# 케이블 길이 합계
max_cable = max(cables)

start, end = 1, max_cable
answer = 0


while start <= end:
    cnt = 0
    mid = (start + end) // 2
    cnt = 0
    for cable in cables:
        cnt += cable // mid
    # 이진탐색
    if cnt >= N:
        answer = mid  # 일단 저장
        start = mid + 1
    else:
        end = mid - 1

print(answer)

