words = input()
word_list = []
word_len = len(words)
string = ''

for word in words:
    word_list.append(word)
    word_len -= 1
    if word_len == 0:
        for s in word_list:
            string += s
        print(string)
    elif len(word_list) == 10:
        for s in word_list:
            string += s
        print(string)
        string = ''
        word_list = []