def dfs(N, V):
    stack = []
    visited = [0] * (N+1)
    stack.append(V)
    visited[V] = 1
    print(V, end=' ')
    while stack:
        top = stack[-1]
        for v in range(N+1):
            if adj[top][v] == 1  and not visited[v]:
                stack.append(v)
                visited[v] = 1
                print(v, end=' ')  
                break
        else:
            stack.pop()
    print()            

    
def bfs(N, V):
    queue = []
    visited = [0] * (N+1)
    queue.append(V)
    visited[V] = 1
    while queue:
        front = queue.pop(0)
        print(front, end=' ')
        for v in range(N+1):
            if adj[front][v] and not visited[v]:
                queue.append(v)
                visited[v] = 1
    print()



N, M, V = map(int,input().split())

adj = [[0] * (N+1) for _ in range(N+1)]

for _ in range(M):
    A, B = map(int,input().split())
    adj[A][B] = 1
    adj[B][A] = 1
dfs(N, V)
bfs(N, V)