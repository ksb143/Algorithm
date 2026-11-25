# [level 0] 중앙값 구하기 - 120811 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/120811) 

## 💭 풀이 기록

**상태**: ✅ 혼자 해결

**느낀 점**

1. 자바의 변수와 메소드를 구분하는 것이 필요하다. 
- 어디에 소속되어 있는가? → static(클래스에 소속) vs instance(객체에 소속)
- 어떤 역할을 하는가? → 필드=변수(데이터를 저장) vs 메소드=함수(동작을 수행)

| 구분 | 호출 방식 | 예시 |
| :--- | :--- | :--- |
| static 필드 | 클래스.변수 | `Math.PI` |
| static 메소드 | 클래스.메소드() | `Arrays.sort(array)` |
| 인스턴스 필드 | 객체.변수 | `array.length` |
| 인스턴스 메소드 | 객체.메소드() | `str.length()` |

예시 사례
```
array.length   // 배열: 인스턴스 필드
str.length()   // 문자열: 인스턴스 메소드
list.size()    // 리스트: 인스턴스 메소드
Math.PI        // static 필드
Math.abs(-10)  // static 메소드
```

2. 공식문서 보는 순서 (헷갈리는 경우 `Method Summary`를 찾아보자!)
- Field Summary : 어떤 필드를 제공하는가?
- Method Summary : 어떤 메소드를 제공하는가?
- static 여부 : 클래스에서 호출하는가, 객체에서 호출하는가?
- Parameters : 어떤 매개변수를 전달해야 하는가?
- Returns : 어떤 값을 반환하는가?

### 성능 요약

메모리: 77.9 MB, 시간: 3.91 ms

### 구분

코딩테스트 연습 > 코딩테스트 입문

### 채점결과

정확성: 100.0<br/>합계: 100.0 / 100.0

### 제출 일자

2026년 11월 25일 16:52:08

### 문제 설명

<p>중앙값은 어떤 주어진 값들을 크기의 순서대로 정렬했을 때 가장 중앙에 위치하는 값을 의미합니다. 예를 들어 1, 2, 7, 10, 11의 중앙값은 7입니다. 정수 배열 <code>array</code>가 매개변수로 주어질 때, 중앙값을 return 하도록 solution 함수를 완성해보세요.</p>

<hr>

<h5>제한사항</h5>

<ul>
<li><code>array</code>의 길이는 홀수입니다.</li>
<li>0 &lt; <code>array</code>의 길이 &lt; 100</li>
<li>-1,000 &lt; <code>array</code>의 원소 &lt; 1,000</li>
</ul>

<hr>

<h5>입출력 예</h5>
<table class="table">
        <thead><tr>
<th>array</th>
<th>result</th>
</tr>
</thead>
        <tbody><tr>
<td>[1, 2, 7, 10, 11]</td>
<td>7</td>
</tr>
<tr>
<td>[9, -1, 0]</td>
<td>0</td>
</tr>
</tbody>
      </table>
<hr>

<h5>입출력 예 설명</h5>

<p>입출력 예 #1</p>

<ul>
<li>본문과 동일합니다.</li>
</ul>

<p>입출력 예 #2</p>

<ul>
<li>9, -1, 0을 오름차순 정렬하면 -1, 0, 9이고 가장 중앙에 위치하는 값은 0입니다.</li>
</ul>


> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
