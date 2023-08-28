def omok():
    cnt_dr = [0] * (N * 2 - 1)
    cnt_dl = [0] * (N * 2 - 1)
    for r in range(N):
        cnt_c = 0
        cnt_r = 0
        # col 검사
        for c in range(N):
            # 돌일 때 카운트
            if baduk[r][c] == 'o':
                cnt_c += 1
                # 오목의 끝일 때
                if c == N-1:
                    # 오목 점수 얻은 경우
                    if cnt_c >= 5:
                        return 'YES'
            # 돌이 없을 때
            else:
                # 오목 점수 얻은 경우
                if cnt_c >= 5:
                    return 'YES'
                # 오목 점수 못얻었을 때 cnt만 초기화
                else:
                    cnt_c = 0
            # row 검사
            # 돌일 때 카운트
            if baduk[c][r] == 'o':
                cnt_r += 1
                # 오목의 끝일 때
                if c == N-1:
                    # 오목 점수 얻은 경우
                    if cnt_r >= 5:
                        return 'YES'
            # 돌이 없을 때
            else:
                # 오목 점수 얻은 경우
                if cnt_r >= 5:
                    return 'YES'
                # 오목 점수 못얻었을 때 cnt만 초기화
                else:
                    cnt_r = 0

            # 좌상 우하 대각선
            for dl in range(N * 2 - 1):
                if r - c == diagonal_left[dl]:
                    if baduk[r][c] == 'o':
                        cnt_dl[dl] += 1
                        # 오목의 끝일 때
                        if r == N - 1  or c == N -1:
                            # 오목 점수 얻은 경우
                            if cnt_dl[dl] >= 5:
                                return 'YES'
                    else:
                        # 오목 점수 얻은 경우
                        if cnt_dl[dl] >= 5:
                            return 'YES'
                        # 오목 점수 못얻었을 때 cnt만 초기화
                        else:
                            cnt_dl[dl] = 0

            # 우상 좌하 대각선
            for dr in range(N * 2 - 1):
                if r + c == diagonal_right[dr]:
                    if baduk[r][c] == 'o':
                        cnt_dr[dr] += 1
                        # 오목의 끝일 때
                        if r == N - 1 or c == 0:
                            # 오목 점수 얻은 경우
                            if cnt_dr[dr] >= 5:
                                return 'YES'
                    else:
                        # 오목 점수 얻은 경우
                        if cnt_dr[dr] >= 5:
                            return 'YES'
                        # 오목 점수 못얻었을 때 cnt만 초기화
                        else:
                            cnt_dr[dr] = 0
    return 'NO'


T = int(input())
for tc in range(1, T+1):
    N = int(input())
    baduk = [list(input()) for _ in range(N)]
    diagonal_right = []
    diagonal_left = []
    for num in range(N * 2 - 1):
        diagonal_right.append(num)
        diagonal_left.append(num-N+1)
    result = omok()
    print(f'#{tc} {result}')

