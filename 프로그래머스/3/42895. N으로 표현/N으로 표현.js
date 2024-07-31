function solution(N, number) {
  const dp = new Array(9).fill().map(() => new Set())

  for (let i = 1; i < 9; i++) {
    // 문자열 반복은 repeat
    dp[i].add(Number(String(N).repeat(i)))
  }

  // 4중 포문으로 다 확인하기!
  for (let i = 1; i < 9; i++) {
    for (let j = 1; j < i; j++) {
      for (let x of dp[j]) {
        for (let y of dp[i-j]) {
          dp[i].add(x + y)
          dp[i].add(x - y)
          dp[i].add(x * y)
          if (y !== 0) {
            dp[i].add(Math.floor(x / y))
          }
        }
      }
    }
    // set에 특정요소 있는지 확인은 has 메소드
    if (dp[i].has(number)) {
      return i
    }
  }
  return -1
}


console.log(solution(5, 12))