cc, cr, rc, rr = map(int, input().split())

# 거리 모아놓은 리스트
distance = []

# 최소 거리 기본값
min_d = 1000

# 상하좌우 거리재기
distance.append(rc - cc) # 우
distance.append(cc - 0) # 좌
distance.append(rr - cr) # 상
distance.append(cr - 0) # 하

# 최소 거리 찾기
for i in distance:
    if min_d > i:
        min_d = i

print(min_d)