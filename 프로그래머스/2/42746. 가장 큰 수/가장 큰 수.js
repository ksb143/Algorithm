function solution(numbers) {

  const strNumber = numbers.map(String)
  // 정렬
  strNumber.sort((a, b) => (b + a) - (a + b))
  
  // 문자열로 바꾸어 출력
  result = strNumber.join('')

  // 결과값이 0이면 0 반환
  return result[0] === '0' ? '0' : result
}