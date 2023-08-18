def palindrome():
    cnt = 0
    # 행 검사
    for r in range(8):
        # 팰린드롬 검사할 열까지
        for c in range(8-N+1):
            for i in range(N//2):
                # 팰린드롬이 아니면 돌아가기
                if arr[r][c+i] != arr[r][c+N-1-i]:
                    break
            # 팰린드롬이면 cnt 증가
            else:
                cnt += 1
    # 열 검사
    for r in range(8):
        # 팰린드롬 검사할 행까지
        for c in range(8-N+1):
            for i in range(N//2):
                # 팰린드롬이 아니면 돌아가기
                if arr[c+i][r] != arr[c+N-1-i][r]:
                    break
            # 팰린드롬이면 cnt 증가
            else:
                cnt += 1
    # 총 팰린드롬 개수 리턴
    return cnt

for tc in range(1, 11):
    N = int(input())
    arr = [list(input()) for _ in range(8)]
    cnt = palindrome()
    print(f'#{tc} {cnt}')

