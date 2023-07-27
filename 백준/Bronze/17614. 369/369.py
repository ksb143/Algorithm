# 369 진행 정도
T = int(input())

# 369 진행 정도 리스트화 (문자열로 저장 - 나중에 반복문 돌리기 위해서)
game_result = list(map(str, list(range(1, T+1))))
# 369 박수 카운트
cnt = 0

for i in range(len(game_result)):
    # 각 리스트에 있는 개별 요소 문자열 반복
    for j in game_result[i]:
        # 3으로 나눠지면 3, 6, 9중에 하나니까 박수 카운트 하기
        if int(j) % 3 == 0 and int(j) != 0:
            cnt += 1

print(cnt)