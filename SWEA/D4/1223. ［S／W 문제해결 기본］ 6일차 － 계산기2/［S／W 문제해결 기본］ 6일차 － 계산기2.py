isp = {'+': 1, '*': 2}


def change_postfix(word):
    lst = []
    stack = []
    for s in word:
        # 피연산자일 경우
        if s not in '+*':
            lst.append(s)
        # 연산자일 경우
        else:
            # 우위일 경우
            if not stack or isp[s] > isp[stack[-1]]:
                stack.append(s)
            # 우위가 아닐 경우 우위가 될 때까지 및 stack이 없어질때 까지 pop
            else:
                while stack and isp[s] <= isp[stack[-1]]:
                    lst.append(stack.pop())
                stack.append(s)

    # 남은 연산자 있으면 다 빼내기
    while stack:
        lst.append(stack.pop())
    return lst


def cal_postfix(postfix):
    stack = []
    for x in postfix:
        # 피연산자면 스택에 넣기
        if x not in '+*':
            stack.append(x)
        # 연산자면 계산해서 스택에서 두 개 빼서 넣기
        else:
            op2 = int(stack.pop())
            op1 = int(stack.pop())
            if x == '+':
                stack.append(op1 + op2)
            elif x == '*':
                stack.append(op1 * op2)
    return stack


for tc in range(1, 11):
    N = int(input())
    word = input()
    postfix = change_postfix(word)
    result = cal_postfix(postfix)
    print(f'#{tc}', *result)

