T = int(input())
for tc in range(1, T+1):
    N, M, K = map(int, input().split())
    people = list(map(int, input().split()))

    # 손님 정렬 (먼저 온 순서대로 줄 세우기)
    for i in range(N):
        min_idx = i
        for j in range(i+1, N):
            if people[min_idx] > people[j]:
                min_idx = j
        people[i], people[min_idx] = people[min_idx], people[i]

    # 제일 처음 붕어빵 만들어 놓기
    fish = K
    time = M

    # 손님에게 붕어빵 나눠주기
    for person in people:
        # 붕어빵이 있다면
        if fish > 0:
            # 그 붕어빵을 만든 시간보다 손님이 늦거나 같게 왔을 경우
            if time <= person:
                # 손님이 붕어빵 가져갔으니 하나 없애기
                fish -= 1
            # 그 붕어빵을 만든 시간보다 손님이 빨리 왔을 경우 불가능 외치고 반복문 종료
            else:
                print(f'#{tc} Impossible')
                break
        # 붕어빵이 소진 됐을 경우
        else:
            # 붕어빵 및 시간 추가
            fish += K
            time += M
            # 그 붕어빵을 만든 시간보다 손님이 늦거나 같게 왔을 경우
            if time <= person:
                # 손님이 붕어빵 가져갔으니 하나 없애기
                fish -= 1
            # 그 붕어빵을 만든 시간보다 손님이 빨리 왔을 경우 불가능 외치고 반복문 종료
            else:
                print(f'#{tc} Impossible')
                break
    # 만약 break 없이 모든 붕어빵 나눠주었다면 진기는 붕어빵 다 팔 수 있었음
    else:
        print(f'#{tc} Possible')
