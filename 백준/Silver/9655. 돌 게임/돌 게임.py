N = int(input())
sk_win = True

# 완벽히 3으로 나뉘어질 때
if N % 3 == 0:
    # 짝수 번째에 승리자가 나오면 창영이가 이긴 것으로 교체, 홀수면 그대로
    if (N // 3) % 2 == 0:
        sk_win = False
# 완벽히 3으로 나뉘어지지 않을 때
else:
    num = 0 # 승리자가 누군지 확인할 수 있는 num
    num += N // 3 # 승리자가 나오는 순서 짝, 홀인지 세기 위한 num
    N = N % 3 # 나머지 남은 돌 개수 확인
    num += N # 승리자가 나오는 순서 짝, 홀인지 세기 위한 num  
    # 짝수 번째에 승리자가 나오면 창영이가 이긴 것으로 교체, 홀수면 그대로    
    if num % 2 == 0:
        sk_win = False

# 홀수면 상근이 승리, 짝수면 창영이 승리
if sk_win:
    print('SK')
else:
    print('CY')
