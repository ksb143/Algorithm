word = input()

# 알파벳 전부 검사 (아스키 코드 이용)
for i in range(97, 123):
    print(word.find(chr(i)), end = ' ')