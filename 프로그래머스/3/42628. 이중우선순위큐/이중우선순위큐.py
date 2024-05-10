def solution(operations):
    queue =[]
    for op in operations:
        if op[0] == "I":
            queue.append(int(op[1:]))
        elif op == "D 1":
            if queue:
                queue.remove(max(queue))
        elif op == "D -1":
            if queue:
                queue.remove(min(queue))
    
    if queue:
        return [max(queue), min(queue)]
    else:
        return [0,0]