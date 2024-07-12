function perm(cnt, visited, arr, k, dungeons) {
  // 만약 순열 길이가 전체 길이와 같다면 (기저 조건)
  if (cnt >= 0) {
    arr.push(cnt)
  } 
  for (let i = 0; i < dungeons.length; i++) {
    // 해당 던전 미방문 & 최소 피로도 만족
    if (visited[i] === 0 && dungeons[i][0] <= k) {
      visited[i] = 1
      k -= dungeons[i][1]
      // 재귀
      perm(cnt + 1, visited, arr, k, dungeons)
      // 원상복귀
      visited[i] = 0
      k += dungeons[i][1]
    } 
  }
  
  
}

function solution(k, dungeons) {
    const visited = Array(dungeons.length).fill(0)
    const arr = []
    perm(0, visited, arr, k, dungeons)
    return Math.max(...arr)
}