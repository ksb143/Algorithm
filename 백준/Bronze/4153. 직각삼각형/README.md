# [Bronze III] 직각삼각형 - 4153 

[문제 링크](https://www.acmicpc.net/problem/4153) 

### 성능 요약

메모리: 31256 KB, 시간: 44 ms

### 분류

기하학, 수학, 피타고라스 정리

### 문제 설명

<p><img alt="" src="https://www.acmicpc.net/upload/images3/rope-triangle.gif" style="float:right; height:229px; width:252px"> 과거 이집트인들은 각 변들의 길이가 3, 4, 5인 삼각형이 직각 삼각형인것을 알아냈다. 주어진 세변의 길이로 삼각형이 직각인지 아닌지 구분하시오.</p>

### 입력 

 <p>
	입력은 여러개의 테스트케이스로 주어지며 마지막줄에는 0 0 0이 입력된다. 각 테스트케이스는 모두 30,000보다 작은 양의 정수로 주어지며, 각 입력은 변의 길이를 의미한다.
</p>

### 출력 

 <p>각 입력에 대해 직각 삼각형이 맞다면 "right", 아니라면 "wrong"을 출력한다.</p>

### 여려웠던 점

 <p>아래 코드는 왜 작동안하는지 모르겠다... 반례가 있는걸까? 근데 반례를 도무지 모르겠다 스트레스 받아</p>

```
while True:
    x, y, z = map(int, input().split())
    # 마지막 테스트일 경우 while 문 멈추기
    if x == 0 and y == 0 and z == 0:
        break
    # 주어진 input 값에서 최대 값 및 해당 인덱스 찾기
    if x != 0 and y != 0 and z != 0:
        max_num = 0
        lst = [x, y, z]
        for i in range(3):
            if lst[i] > max_num:
                max_num = lst[i]
                max_idx = i
        # 최대 값에 해당하는 인덱스 분리해서 제곱하기
        rest = 0
        for i in range(3):
            if i == max_idx:
                heru = lst[i] ** 2
            else:
                rest += lst[i] ** 2
        # 직각 삼각형 검사
        if heru == rest:
            print('rignt')
        else:
            print('wrong')
```

