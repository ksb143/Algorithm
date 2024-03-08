def solution(answers):
    supo1, check1  = [1, 2, 3, 4, 5], 0
    supo2, check2 = [2, 1, 2, 3, 2, 4, 2, 5], 0
    supo3, check3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5], 0
    ans_len = len(answers)
    for i in range(ans_len):
        if supo1[i % 5] == answers[i]:
            check1 += 1
        if supo2[i % 8] == answers[i]:
            check2 += 1
        if supo3[i % 10] == answers[i]:
            check3 += 1
    
    result = []
    max_num = max(check1, check2, check3)
    if max_num == check1:
        result.append(1)
    if max_num == check2:
        result.append(2)
    if max_num == check3:
        result.append(3)
        
    return result