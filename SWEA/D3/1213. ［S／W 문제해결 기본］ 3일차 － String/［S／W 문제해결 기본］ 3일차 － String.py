for _ in range(10):
    tc = int(input())
    p = input()
    t = input()
    M = len(p)
    N = len(t)
    i = 0
    j = 0
    cnt = 0
    while j < M and i < N:
        if t[i] != p[j]:
            i = i - j
            j = -1
        i += 1
        j += 1
        if j == M:
            cnt += 1
            j = 0
    print(f'#{tc} {cnt}')



