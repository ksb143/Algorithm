num_list = []

# 수 리스트 삽입
for i in range(9):
    num_list.append(int(input()))

# 최대값 기본 제일 처음 인덱스
max = num_list[0]

# 최대값 찾는 법
for i in range(1, 9):
    if max < num_list[i]:
        max = num_list[i]

print(max)
print(num_list.index(max) + 1)