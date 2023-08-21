# 중위 순회 함수
def inorder(n):
    if n:
        inorder(ch1[n])
        print(tree[n], end='')
        inorder(ch2[n])

for tc in range(1, 11):
    N = int(input())
    # tree 내부에 있는 문자
    tree = [0] * (N + 1)
    # 해당 트리의 자식 노드
    ch1 = [0] * (N + 1)
    ch2 = [0] * (N + 1)

    
    for _ in range(N):
        lst = input().split()
        node = int(lst.pop(0))
        word = lst.pop(0)
        # 해당 노드의 글자 넣기
        tree[node] = word
        # 해당 노드의 자식 노드 표시해주기
        if lst:
           ch1[node] = int(lst.pop(0))
        if lst:
            ch2[node] = int(lst.pop(0))
    print(f'#{tc} ', end='')
    inorder(1)
    print()