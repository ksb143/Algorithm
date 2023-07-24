def pibo(x):
    curr, next = 0, 1
    for _ in range(x):
        curr, next = next, curr + next
    return curr 

print(pibo(int(input())))


# # 저장했다 가져다쓰기.... memoization (재귀함수)

# cnt = 0
# arr = [0] * 301
# def f(N):
#     global cnt
#     cnt += 1
#     if arr[N] == 0:
#         if N <= 1:
#             arr[N] = 1
#             return 1
#         arr[N] = f(N-1) + f(N-2)
#         return arr[N]
#     return arr[N]

# #호출 횟수를 줄이자 이미 호출 된 애는 호출 하지 말자
# # 호출 된 애인지 아닌지 표시하는 배열

# print(f(3))
