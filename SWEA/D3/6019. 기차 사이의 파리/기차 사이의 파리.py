T = int(input())

for tc in range(1, T+1):
    D, A, B, F = map(float, input().split())
    # 두 기차가 부딪힐 때 걸린 시간 == 파리가 움직이는 시간
    # D * (A+B) = x / F (x가 내가 구해야하는 것)
    print(f'#{tc} {F * (D / (A + B))}')