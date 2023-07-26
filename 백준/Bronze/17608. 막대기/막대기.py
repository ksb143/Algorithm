import sys

# 막대기 수 부여
bar_num = int(sys.stdin.readline())

# 막대 높이 집어넣는 빈 리스트 생성
bar_lst = []

# 보이는 막대기 세는 수
cnt = 1

# 막대기 높이 리스트에 집어넣기
for _ in range(bar_num):
    bar_lst.append(int(sys.stdin.readline()))

# 최대값 바 (디폴트 - 스택 제일 오른쪽)
max_bar = bar_lst[-1]

# 최대 높이 막대기 보다 크면 cnt 1 증가
for i in bar_lst[::-1]:
    if i > max_bar:
        cnt += 1
        # 최대 높이 막대기 교체
        max_bar = i

print(cnt)