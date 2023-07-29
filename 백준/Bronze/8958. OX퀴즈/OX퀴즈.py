T = int(input())

for _ in range(T):
    quiz_results = input()
    score = 0
    score_lst =[]
    for i in quiz_results:
        if i == 'O':
            score = (score + 1)
            score_lst.append(score)
        elif i == 'X':
            score = 0
            score_lst.append(score)
    print(sum(score_lst))