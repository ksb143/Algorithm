function solution(m, n, puddles) {
  // 2차원 배열 초기화
  const dp = Array.from({ length: n }, () => new Array(m).fill(0));

  // 출발지점 초기화
  dp[0][0] = 1;

  // 물에 잠긴 지역 표시
  for (const [pc, pr] of puddles) {
    dp[pr - 1][pc - 1] = -1; // 주의: puddles의 좌표는 1-based, dp는 0-based
  }

  for (let r = 0; r < n; r++) {
    for (let c = 0; c < m; c++) {
      if (dp[r][c] === -1) {
        dp[r][c] = 0; // 물에 잠긴 지역은 경로가 없으므로 0으로 설정
        continue;
      }
      if (r > 0) dp[r][c] += dp[r - 1][c];
      if (c > 0) dp[r][c] += dp[r][c - 1];
      dp[r][c] %= 1000000007; // 문제의 요구사항에 따라 모듈로 연산
    }
  }

  return dp[n - 1][m - 1];
}