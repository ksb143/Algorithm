def recur(cur, start):
    global num
    if cur == n:
        arr[num] = 1
        return
 
 
    for i in range(start, 4):
        num += li[i]
        recur(cur + 1, i)
        num -= li[i]
 
 
n = int(input())
li = [1, 5, 10, 50]
arr = [0] * (50 * 20 + 1)
num = 0
recur(0, 0)
print(sum(arr))