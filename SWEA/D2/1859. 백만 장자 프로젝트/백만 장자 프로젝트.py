T = int(input())
for tc in range(1, T+1):
    N = int(input())
    case = list(map(int, input().split()))
    money = 0
    start = 0
    end = N
    # 인덱스 값으로 판단하기 때문에 end-1까지
    while start <= end-1:
        max_cost = 0
        # 맥스 값 인덱스 구하기
        for i in range(start, end):
            if case[i] > max_cost:
                max_cost = case[i]
                max_idx = i
        # 맥스 값 인덱스가 젤 처음이 아닐 경우
        if max_idx != start:
            for j in range(start, max_idx):
                money += (case[max_idx] - case[j])
        # 스타트 증가
        start = max_idx + 1
    print(f'#{tc} {money}')