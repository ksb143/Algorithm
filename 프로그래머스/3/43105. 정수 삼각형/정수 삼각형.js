function solution(triangle) {
  const N = triangle.length  // 삼각형 깊이

  const dp = triangle.map(row => [...row])

  // 밑에서 올라가가며 최대 경로 합 계산
  for (let i = N - 2; i >= 0; i--) {
    for (let j = 0; j < triangle[i].length; j++) {
      // 점진적으로 밑에서 더해줌!
      dp[i][j] += Math.max(dp[i + 1][j], dp[i + 1][j + 1])
    }
  }
  return dp[0][0]
}