class MinHeap {
  constructor() {
    this.heap = [null];
  }

  get size() {
    return this.heap.length - 1;
  }

  get min() {
    return this.heap[1];
  }

  swap(idx1, idx2) {
    [this.heap[idx1], this.heap[idx2]] = [this.heap[idx2], this.heap[idx1]];
  }

  heappush(value) {
    this.heap.push(value);
    this.heapifyUp();
  }

  heapifyUp() {
    let idx = this.heap.length - 1;
    while (idx > 1 && this.heap[Math.floor(idx / 2)][0] > this.heap[idx][0]) {
      this.swap(Math.floor(idx / 2), idx);
      idx = Math.floor(idx / 2);
    }
  }

  heappop() {
    if (this.size === 0) {
      return null;
    }
    if (this.size === 1) {
      return this.heap.pop();
    }
    const min = this.heap[1];
    this.heap[1] = this.heap.pop();
    this.heapifyDown(1);
    return min;
  }

  heapifyDown(idx) {
    while (idx * 2 < this.heap.length) {
      let smallerChildIndex = idx * 2;
      if (smallerChildIndex + 1 < this.heap.length && this.heap[smallerChildIndex + 1][0] < this.heap[smallerChildIndex][0]) {
        smallerChildIndex++;
      }

      if (this.heap[idx][0] <= this.heap[smallerChildIndex][0]) {
        break;
      }
      this.swap(idx, smallerChildIndex);
      idx = smallerChildIndex;
    }
  }
}

function solution(jobs) {
  const minHeap = new MinHeap();
  jobs.sort((a, b) => a[0] - b[0]);

  let length = jobs.length;
  let totalTime = 0;
  let currentTime = 0;
  let i = 0;

  while (i < length || minHeap.size > 0) {
    // 현재 시간에 도달한 작업들을 힙에 추가
    while (i < length && jobs[i][0] <= currentTime) {
      minHeap.heappush([jobs[i][1], jobs[i][0]]);
      i++;
    }

    // 힙이 비어 있으면 다음 작업까지 시간을 이동
    if (minHeap.size === 0) {
      currentTime = jobs[i][0];
    } else {
      const [jobDuration, jobStart] = minHeap.heappop();
      currentTime += jobDuration;
      totalTime += currentTime - jobStart;
    }
  }

  return Math.floor(totalTime / length);
}

console.log(solution([[0, 3], [1, 9], [2, 6]])); // Expected output: 9