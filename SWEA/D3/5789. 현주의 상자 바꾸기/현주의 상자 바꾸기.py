T = int(input())

for tc in range(1, T+1):
    N, Q = map(int, input().split())
    # N+1 하는 이유는 N번 박스까지 계산하기 위해서
    boxes = [0] * (N+1)
    for q in range(1, Q+1):
        L, R = map(int, input().split())
        for num in range(L, R+1):
            boxes[num] = q
    print(f'#{tc}', *boxes[1:])