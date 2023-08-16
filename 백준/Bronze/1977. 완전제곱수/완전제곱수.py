N = int(input())
M = int(input())

cnt = 0
min_num = 10000
for i in range(N, M+1):
    temp = i
    # 거듭제곱인 것 구하기
    i = i ** (1/2)
    # 실수를 정수화 한 후 그것이 그전 실수와 똑같으면 자연수인 것
    if i == int(i):
        cnt += temp
        # 최소값 구하기
        if min_num > cnt:
            min_num = cnt

# 완전제곱수가 없는 경우
if cnt == 0:
    print(-1)
else:
    print(cnt)
    print(min_num)