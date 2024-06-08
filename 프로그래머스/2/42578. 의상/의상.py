def solution(clothes):
    clothes_type = {}
    for name, types in clothes:
        if types in clothes_type:
            clothes_type[types] += 1
        else:
            clothes_type[types] = 1
    answer = 1
    for key, value in clothes_type.items():
        answer *= (value + 1)
    answer -= 1
    return answer