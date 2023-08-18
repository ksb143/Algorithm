T = int(input())

for tc in range(1, T+1):
    N = int(input())
    arr = list(map(int, input().split()))

    # 최소값의 인덱스 기본 설정
    min_idx = 0
    # 최대값의 인덱스 기본 설정
    max_idx = 0

    # 인덱스 찾기
    for i in range(1, N):
        # 작으면 선택
        if arr[min_idx] > arr[i]:
            min_idx = i
        # 크거나 같으면 선택택
        if arr[max_idx] <= arr[i]:
            max_idx = i

    # 절대값을 구하도록 하기
    if max_idx > min_idx:
        print(f'#{tc} {max_idx - min_idx}')
    else:
        print(f'#{tc} {min_idx - max_idx}')
