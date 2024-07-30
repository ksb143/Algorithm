function solution(name) {
  const N = name.length
  const currentState = 'A'.repeat(N)
  if (currentState === name) {
    return 0
  }

  let cnt = 0

  for (let i = 0 ; i < N; i++) {
    const moveNum = Math.min((name.charCodeAt(i) - 65), (91 - name.charCodeAt(i)))
    cnt += moveNum
  }

  let minMove = 40

  for (let i=0; i < N; i++) {
    let nextIdx = i + 1
    while (nextIdx < N && name[nextIdx] == 'A') {
      nextIdx++
    }

    // 오른쪽 갔다가 왼쪽가기
    let distanceR = i + i + N - nextIdx
    minMove = Math.min(minMove, distanceR)

    // 왼쪽 갔다가 오른쪽 가기
    let distanceL = (N - nextIdx) * 2 + i
    minMove = Math.min(minMove, distanceL)
  }


  return cnt + minMove;
}

console.log(solution('JEROEN'))