T = int(input())
prime = [2, 3, 5, 7, 11]
for tc in range(1, T+1):
    N = int(input())
    num = []
    for i in prime:
        cnt = 0
        # 나눠지면 나눠질 때까지 나눠서 +1
        while N % i == 0:
            N = N // i
            cnt += 1
        num.append(cnt)
    # 출력을 위해서 tc와 소인수분해 결과값을 나눔
    print(f'#{tc}', end=' ')
    for j in num:
        print(j, end=' ')
    print()





