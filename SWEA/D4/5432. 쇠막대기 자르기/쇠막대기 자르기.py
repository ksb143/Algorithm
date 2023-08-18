T = int(input())
for tc in range(1, T+1):
    stick = input()
    # 반복문 돌리는 수
    n = len(stick)
    # 잘릴 쇠막대기 들어가는 stack
    stack = []
    # 쇠막대기 나눠진 개수 초기값
    cnt = 0
    for i in range(n):
        if stick[i] == '(':
            stack.append(stick[i])
        elif stick[i] == ')':
            # 레이저 경우
            if stick[i-1] == '(':
                stack.pop()
                cnt += len(stack)
            # 쇠막대기일 경우 남은 쇠막대기 개수 더해주고 스택에서 빼기
            else:
                cnt += 1
                stack.pop()

    print(f'#{tc} {cnt}')
