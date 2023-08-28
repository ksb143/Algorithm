T = int(input())

for tc in range(1, T+1):
    memory = list(map(int, input()))

    # 기본 체크값 1
    check = 1
    cnt = 0

    for bit in memory:
        # bit가 체크와 같으면
        if bit == check:
            # 카운트 세고
            cnt += 1
            # 체크값 바꿔주기
            if check == 1:
                check = 0
            else:
                check = 1

    print(f'#{tc} {cnt}')

