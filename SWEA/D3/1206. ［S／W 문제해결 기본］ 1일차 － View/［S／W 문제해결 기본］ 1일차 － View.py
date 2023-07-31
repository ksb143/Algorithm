for tc in range(1, 11):
    N = int(input())
    building = list(map(int, input().split()))
    right_of_view = 0
    # 전체 건물 반복문
    for i in range(2, len(building)-2):
        # 비교 건물 리스트 만들기
        comparison = [building[i-2], building[i-1], building[i+1], building[i+2]]
        # 비교 건물 중 첫 번째 건물 최대 높이 빌딩 기본으로 지정
        max_b = comparison[0]
        # 비교 건물 중에서 최대 높이 건물 찾기
        for b in comparison:
            if max_b < b:
                max_b = b
        # 비교 건물 중 최대 높이 건물보다 현 건물이 높다면 조망권 세대수 추가
        if building[i] > max_b:
            right_of_view += building[i] - max_b
    print(f'#{tc} {right_of_view}')
