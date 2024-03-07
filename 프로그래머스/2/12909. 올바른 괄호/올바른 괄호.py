def solution(strings):
    stack = []
    answer = True
    for string in strings:
        # 여는 괄호
        if string == '(':
            stack.append(string)
        # 닫는 괄호
        else:
            # 여는 괄호가 있을 경우
            if stack:
                stack.pop()
            # 여는 괄호가 없을 경우
            else:
                answer = False
                break
    else:
        # 여는 괄호가 남았을 경우
        if stack:
            answer = False

    return answer