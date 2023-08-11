T = int(input())

for tc in range(T):
    num, S = input().split()
    # 해당 문자열 반복문
    for i in S:
        # 해당 문자 num만큼 반복
        for j in range(int(num)):
            print(i, end='')
    # 다 반복하면 엔터
    print()