def preorder(p):
    if p != '.':
        print(p, end='')
        preorder(tree[p][0])
        preorder(tree[p][1])

def inorder(p):
    if p != '.':
        inorder(tree[p][0])
        print(p, end='')
        inorder(tree[p][1])

def postorder(p):
    if p != '.':
        postorder(tree[p][0])
        postorder(tree[p][1])
        print(p, end='')


N = int(input())

# 트리 딕셔너리
tree = {}

for _ in range(N):
    p, ch1, ch2 = input().split()
    tree[p] = [ch1, ch2]
preorder('A')
print()
inorder('A')
print()
postorder('A')