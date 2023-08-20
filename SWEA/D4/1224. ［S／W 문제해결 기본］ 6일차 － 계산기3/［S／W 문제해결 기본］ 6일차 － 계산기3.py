icp = {'(' : 3, '+' : 1, '*' : 2}
isp = {'(' : 0, '+' : 1, '*' : 2}


def change_postfix(exp):
    postfix = ''
    stack = []
    for i in exp:
        if i not in '()+*':
            postfix += i
        else:
            if i in '(+*':
                if not stack:
                    stack.append(i)
                elif isp[stack[-1]] < icp[i]:
                    stack.append(i)
                else:
                    while stack and isp[stack[-1]] >= icp[i]:
                        postfix += stack.pop()
                    stack.append(i)
            else:
                while stack[-1] != '(':
                    postfix += stack.pop()
                stack.pop()
    return postfix


def cal(postfix):
    stack = []
    for n in postfix:
        if n not in '+*':
            stack.append(int(n))
        else:
            op2 = stack.pop()
            op1 = stack.pop()
            if n == '+':
                stack.append(op1 + op2)
            elif n == '*':
                stack.append(op1 * op2)
    return stack.pop()


for tc in range(1, 11):
    N = int(input())
    exp = input()
    result = cal(change_postfix(exp))
    print(f'#{tc} {result}')
