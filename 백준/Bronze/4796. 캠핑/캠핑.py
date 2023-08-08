num = 0
while True:
    # 케이스 수 세기
    num += 1
    # 최대 박수 셀 cnt
    cnt = 0
    L, P, V = map(int, input().split())
    # L이 0이면 빠져나오기
    if L == 0 and P == 0 and V == 0:
        break
    # 강산이 휴가기간 나누기 캠핑 전체 일수 나머지가 캠핑 실 이용일수보다 작은 경우 
    if V % P < L:
        # 연속 이용 더하기
        cnt += (V // P) * L
        # 남은 일수 더하기
        cnt += V % P
    # 강산이 휴가기간 나누기 캠핑 전체 일수 나머지가 캠핑 실 이용일수보다 큰 경우
    else:
        # 연속 이용 더하기
        cnt += (V // P) * L
        # 남은 일수 더하기
        cnt += L
    print(f'Case {num}: {cnt}')
