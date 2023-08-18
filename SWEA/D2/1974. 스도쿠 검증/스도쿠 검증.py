def sudoku():
    # 행검사
    for r in range(9):
        count = [0] * 10
        # 카운트로 스도쿠 점수 count에 추가
        for c in range(9):
            count[arr[r][c]] += 1
        # 카운트 리스트에 스도쿠가 없으면 스도쿠가 부정확하니까 reuturn 0
        for i in range(1, 10):
            if count[i] == 0:
                return 0
    # 열 검사
    for r in range(9):
        count = [0] * 10
        for c in range(9):
            count[arr[c][r]] += 1
        for i in range(1, 10):
            if count[i] == 0:
                return 0
    # 정사각형 검사
    for fr in range(0, 9, 3):
        for fc in range(0, 9, 3):
            count = [0] * 10
            for r in range(fr, fr + 3):
                for c in range(fc, fc + 3):
                    count[arr[r][c]] += 1
            for i in range(1, 10):
                if count[i] == 0:
                    return 0
    # return 안하므로 전체 스도쿠 일치
    return 1


T = int(input())
for tc in range(1, T+1):
    arr = [list(map(int, input().split())) for _ in range(9)]
    result = sudoku()
    print(f'#{tc} {result}')






