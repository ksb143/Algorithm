D, H, W = map(int, input().split())

# 피타고라스 정의 이용
x = D**2 / (H**2 + W**2)

# x의 제곱근 구함
x =  x**(1/2)

# 너비, 높이 구하기
h, w = x * H, x * W

# 소수점 다 떼버리기
print(int(h), int(w)) 