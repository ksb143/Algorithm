import  heapq
def solution(operations):
    answer = [0, 0]
    temp_list = []
    heapq.heapify(temp_list)
    while operations:
        temp = operations.pop(0)
        if temp[0] == "I":
            heapq.heappush(temp_list, int(temp[2:]))
        elif temp[0] == "D":
            if temp_list:
                if temp[2] == "1":
                    temp_list.pop(-1)
                else:
                    temp_list.pop(0)
    temp_list.sort()
    if temp_list:
        answer = [temp_list[-1], temp_list[0]]
    return answer