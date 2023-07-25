changes = [500, 100, 50, 10, 5, 1]
money = 1000 - (int(input()))
cnt = 0

# 큰 순서대로 확인
for change in changes:
    # 잔돈 개수 증가
    cnt += money // change
    # 이미 지불한 잔돈 확인용으로 check 변수 추가
    check = 0
    check += money // change
    money -= change*check

print(cnt)
