T = int(input())
for tc in range(T):
    string = input()

    stack =[]

    for s in string:
        if s == '(':
            stack.append(s)
        else:
            s == ')'
            if stack:
                stack.pop()
            else:
                print('NO')
                break
    else:
        if stack:
            print('NO')
        else:
            print('YES')
