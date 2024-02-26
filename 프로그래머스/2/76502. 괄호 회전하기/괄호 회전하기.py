def solution(s):
    stirng_length = len(s)
    cnt = 0
    for i in range(stirng_length):
        # 문자열 재배치 (시간 多)
        strings = s[i+1:] + s[:i+1]
        # 스택 이용해서 괄호 넣었다가 빼기
        stack = []
        # 여는 괄호 없는 경우
        isOpen = False
        for string in strings:
            # 여는 괄호일 경우
            if string == '(' or string == '{' or string == '[':
                stack.append(string)
                isOpen = True
            # 닫는 괄호일 경우 스택에 들어간 여는 괄호 검사 (모두 닫는 괄호면 어쩌지?)
            else:
                if len(stack) > 0:
                    if stack[-1] == '(' and string == ')':
                        stack.pop()
                    elif stack[-1] == '{' and string == '}':
                        stack.pop()
                    elif stack[-1] == '[' and string == ']':
                        stack.pop()
        if len(stack) == 0 and isOpen:
            cnt += 1
    return cnt