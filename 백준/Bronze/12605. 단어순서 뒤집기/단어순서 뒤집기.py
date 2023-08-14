T = int(input())
for tc in range(1, T+1):
    sentence = input().split()
    stack = []
    # 스택 안에 넣기
    for word in sentence:
        stack.append(word)
    print(f'Case #{tc}:', end=' ')
    # 스택이 없어질 때까지 pop
    while stack:
        print(stack.pop(), end=' ')
    print()