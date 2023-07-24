def pibo(x):
    curr, next = 0, 1
    for _ in range(x):
        curr, next = next, curr + next
    return curr 

print(pibo(int(input())))
