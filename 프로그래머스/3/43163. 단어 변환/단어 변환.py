def solution(begin, target, words):
    if target not in words:
        print(target)
        return 0
    n = len(begin) # 시작 글자 길이
    m = len(words) # 글자 리스트 길이
    visited = [0] * m
    queue = []
    queue.append((begin, 0))
    while queue:
        pop_word, move_cnt = queue.pop(0)
        if pop_word == target:
            return move_cnt
        for i in range(m):
            if visited[i] == 1:
                continue
            cnt = 0
            for j in range(n):
                if pop_word[j] != words[i][j]:
                    cnt += 1
            if cnt <= 1:
                visited[i] = 1
                queue.append((words[i], move_cnt + 1))