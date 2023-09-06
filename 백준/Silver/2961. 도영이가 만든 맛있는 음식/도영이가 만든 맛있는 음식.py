# 비트 연산자 1 << n 이란 1을 n번 밀어라라는 뜻

def solve(N, ts, tb, min_v):
    # 공집합을 없애기 위해서 1부터 시작
    for i in range(1, 1<<N):
        for j in range(N):
            if i&(1<<j):
                ts *= sour[j]
                tb += bitter[j]
        if min_v > abs(ts - tb):
            min_v = abs(ts - tb)
        # ts, tb 초기화
        ts = 1
        tb = 0
    return min_v

N = int(input())

sour = []
bitter = []
min_v = 0xffffffff
ts = 1
tb = 0

for tc in range(N):
    S, B = map(int, input().split())
    sour.append(S)
    bitter.append(B)

print(solve(N, ts, tb, min_v))