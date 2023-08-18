T = int(input())

for tc in range(1, T+1):
    word = input()
    result = 1
    # 회문 검사
    for i in range(len(word)//2):
        # 아니면 result 0
        if word[i] != word[len(word)-1-i]:
            result = 0
    print(f'#{tc} {result}')
