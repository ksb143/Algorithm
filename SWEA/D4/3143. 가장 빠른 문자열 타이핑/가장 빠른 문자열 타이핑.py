T = int(input())

for tc in range(1, T+1):
    A, B = input().split()
    al = len(A)
    bl = len(B)
    start = 0
    cnt = 0
    while start <= al - bl:
        for j in range(bl):
            if A[start+j] != B[j]:
                break
        else:
            cnt += 1
            start += bl - 1
        start += 1
    typing_num = al - cnt * (bl - 1)
    print(f'#{tc} {typing_num}')


