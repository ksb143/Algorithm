for tc in range(1, 11):
    dump = int(input())
    boxes = list(map(int, input().split()))
    # 현재에 가장 높은 박스랑 낮은 박스 사용
    max_box = 0
    min_box = 101
    for i in range(100):
        if boxes[i] > max_box:
            max_box = boxes[i]
            max_box_idx = i
        if boxes[i] < min_box:
            min_box = boxes[i]
            min_box_idx = i
    # dump 횟수만큼 박스 높낮이 바꾸기
    for _ in range(dump):
        boxes[max_box_idx] -= 1
        boxes[min_box_idx] += 1
        max_box = 0
        min_box = 101
        # 평탄화 후 가장 높은 박스랑 낮은 박스 찾기
        for i in range(100):
            if boxes[i] > max_box:
                max_box = boxes[i]
                max_box_idx = i
            if boxes[i] < min_box:
                min_box = boxes[i]
                min_box_idx = i
    print(f'#{tc} {max_box - min_box}')





