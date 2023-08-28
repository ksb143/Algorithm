T = int(input())
for tc in range(1, T+1):
    N = int(input())
    lst = input().split()
    shuffle = []
    if N % 2 == 0:
        n = N // 2
    else:
        n = N // 2 + 1
    front = [lst[x] for x in range(n)]
    rear = [lst[x] for x in range(n, N)]
    order1 = 0
    order2 = 0
    for i in range(N):
        if i % 2 == 0:
            shuffle.append(front[order1])
            order1 += 1
        else:
            shuffle.append(rear[order2])
            order2 += 1

    print(f'#{tc}', *shuffle)

