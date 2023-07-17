T = int(input())

for tc in range(1, T+1):
    k = int(input())
    n = int(input())
    apts = [[0]*(n+2) for x in range(0, k+1)]
    apts[0] = [x for x in range(n+2)]
    for i in range(1, k+1):
        for j in range (1, n+2):
            apts[i][j] = apts[i-1][j] + apts[i][j-1]
    print(apts[k][n])