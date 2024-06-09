def solution(prices):
    stack = []
    n = len(prices)
    for i in range(n):
        time = 0
        for j in range(i + 1, n):
            if prices[i] > prices[j]:
                time += 1
                break
            time += 1
        stack.append(time)
    return stack