function bfs(x, y, n, connectInfo) {
  const visited = Array(n + 1).fill(0)
  visited[x] = 1
  const queue = [x]
  let cnt = 1
  // 큐가 있는 경우에만
  while (queue.length > 0) {
    const curr = queue.shift()
    for (const num of connectInfo[curr]) {
      // 방문한적 없고 끊은 전력망이 아닌경우에만
      if (visited[num] === 0 && num !== y) {
        queue.push(num)
        visited[num] = 1
        cnt += 1
      }
    }
  }
  return cnt
}

function solution(n, wires) {
  // 얕은 복사하는법 (처음 배운 것)
  const connectInfo = Array.from({ length: 101 }, () => []);
  for (const wire of wires) {
    connectInfo[wire[0]].push(wire[1])
    connectInfo[wire[1]].push(wire[0])
  }
  let answer = 100
  for (const wire of wires) {
    const value1 = bfs(wire[0], wire[1], n, connectInfo)
    const value2 = n - value1
    const value = Math.abs(value1- value2)
    if (value < answer) {
      answer = value
    }
  }
  return answer
}