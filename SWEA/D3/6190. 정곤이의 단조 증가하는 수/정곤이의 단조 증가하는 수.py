T = int(input())
for tc in range(1, T+1):
    N = int(input())
    lst = list(map(int, input().split()))
    max_num = -1
    # 곱한 두 글자가 단조인지 판단
    for i in range(N-1):
        for j in range(i+1, N):
            num_st = str(lst[i]*lst[j])
            temp = -1
            for n in num_st:
                if temp > int(n):
                    break
                temp = int(n)
            else:
                num = lst[i] * lst[j]
                if int(num) > max_num:
                    max_num = int(num)
    print(f'#{tc} {max_num}')








