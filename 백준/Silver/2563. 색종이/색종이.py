N = int(input())
data = [[0] * 100 for _ in range(100)]
cnt = 0

for _ in range(N):

    A, B = map(int, input().split())

    i = 100 - B - 10
    j = A



    for a in range(i, i+10):
        for b in range(j, j+10):
            data[a][b] = 1



for a in range(100):
    for b in range(100):
        if data[a][b] == 1:
            cnt += 1

print(cnt)