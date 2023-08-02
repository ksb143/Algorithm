N, M = map(int, input().split())
lst = list(map(int, input().split()))
max_num = 0
# 3개 모두 조사하기 위해 3중 반복문 (시간 오래걸린다는 단점...)
for i in range(0, N-2):
    cnt = 0
    a = lst[i]
    cnt += lst[i]
    for j in range(i+1, N-1):
        b = lst[j]
        cnt += lst[j]
        for x in range(j+1, N):
            c = lst[x]
            cnt += lst[x]
            # max_num이 cnt 보다 크고 M값보다 작거나 같으면 max_num 교체 및 세 번째 카드 값 초기화
            if max_num < cnt and cnt <= M:
                max_num = cnt
                cnt -= lst[x]
            # max_num이 안되도 세 번째 카드 값 초기화
            else:
                cnt -= lst[x] 
        # 두 번째 카드 값 초기화   
        cnt -= lst[j]
    # 첫 번째 카드 초기화
    cnt -= lst[i]
print(max_num)