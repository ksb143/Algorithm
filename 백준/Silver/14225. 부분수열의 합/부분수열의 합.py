# 수열 크기
N = int(input())
#
lst = list(map(int, input().split()))
answer_set = set()

def comb(n, answer):
    if n == N:
        temp = [i for i in answer]
        answer_set.add(sum(temp))
        return
    answer.append(lst[n])
    comb(n + 1, answer)
    answer.pop()
    comb(n + 1, answer)

comb(0, [])

max_value = sum(lst)

for i in range(1, max_value+2):
    if i not in answer_set:
        print(i)
        break
