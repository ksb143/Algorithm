T = int(input())

for tc in range(1, T+1):
     N = int(input())
     farm = [list(map(int, input())) for _ in range(N)]
     mid = N // 2
     harv = 0
     for r in range(N):
         for c in range(N):
             for k in range(mid+1):
                 if abs(r-mid) + abs(c-mid) == k:
                     harv += farm[r][c]
     print(f'#{tc} {harv}')


