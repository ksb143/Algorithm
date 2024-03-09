import math

def yaksoo(number):
    results = []
    max_num = int(math.sqrt(number))
    for i in range(1, max_num + 1):
        if number % i == 0:
            results.append(i)
    return results
    

def solution(brown, yellow):
    # 노란격자 공약수 구하기
    results = yaksoo(yellow)
    
    for result in results:
        # 노란색 부분을 높이와 너비로 구하기
        height, width = result, yellow // result
        # 노란색 부분과 갈색 부분의 합이 맞을 때 break 하고 바로 내보내기
        if (width + 2) * (height + 2) - yellow == brown:
            answer = [width+2, height+2]
            break
    return answer