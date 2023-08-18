for tc in range(1, 11):
    N, string = input().split()
    N = int(N)
    stack = [None] * N
    top = -1
    for i in range(N):
        # 첫번째 글자는 무조건 넣기
        if top == -1:
            top += 1
            stack[top] = string[i]
            continue
        # stack top 위치 글자와 넣을 글자가 다르면 넣기
        if stack[top] != string[i]:
            top += 1
            stack[top] = string[i]
        # stack top 위치 글자와 넣을 글자가 같으면 stack top 위치에 있는 것 빼기
        else:
            stack.pop(top)
            top -= 1

    # 출력
    print(f'#{tc}', end = ' ')
    # None 값은 출력 안하도록 하기
    for i in stack:
        if i != None:
            print(i, end='')
    print()
