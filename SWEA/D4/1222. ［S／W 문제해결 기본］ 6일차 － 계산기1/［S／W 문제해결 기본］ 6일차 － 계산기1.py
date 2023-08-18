for tc in range(1, 11):
    N = int(input())
    formula = input()
    post_formula = ''
    stack = []
    for c in formula:
        # 연산자일 때
        if c == '+':
            # 스택에 아무것도 없을 때
            if not stack:
                stack.append(c)
            # 스택에 무언가가 있을 때
            else:
                post_formula += stack.pop()
                stack.append(c)
        # 피연산자일 때
        else:
            post_formula += c

    # stack에 남아있는 연산자 출력
    while stack:
        post_formula += stack.pop()

    # 후위표기식 계산
    for c in post_formula:
        # 피연산자인 경우 스택에 넣기
        if c != '+':
            stack.append(int(c))
        # + 연산자인 경우 스택에서 빼서 계산 후 그 결과 스택에 다시 넣기
        else:
            op2 = stack.pop()
            op1 = stack.pop()
            stack.append(op1 + op2)
    result = stack.pop()
    print(f'#{tc} {result}')