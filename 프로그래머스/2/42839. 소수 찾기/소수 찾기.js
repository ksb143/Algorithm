// 소수 확인 함수
function isPrime(number) {
  // 1 이하면 바로 false 리턴
  if (number <= 1) {
    return false
  }
  // 자신의 제곱근 이하로 나눠지는 수가 없으면 소수
  checkNum = Math.sqrt(number)
  for (let i = 2;i <= checkNum; i++) {
    if (number % i === 0) {
      return false
    }
  }
  return true
}

// 순열 확인 (재귀함수)
function permutation(numbers, temp, visited, result, len) {
  // 기저 조건
  if (temp.length > 0) {
    const num = Number(temp.join(''))
    if (isPrime(num)) {
      result.add(num)
    }
  }
  // 상태변화
  for (let i = 0; i < len; i++) {
    // 방문 안했을 경우
    if (visited[i] === 0) {
      visited[i] = 1
      temp.push(numbers[i])
      // 재귀 호출
      permutation(numbers, temp, visited, result, len)
      // 복귀
      temp.pop()
      visited[i] = 0
    }
  }
} 

function solution(numbers) {
  const visited = Array(numbers.length).fill(0)
  const result = new Set()
  const temp = []
  const len = numbers.length
  permutation(numbers, temp, visited, result, len)
  return result.size
}
