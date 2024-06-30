// 섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
// k 이상 스코빌 지수
// 모든 음식 k 이상 만들기 위해 섞어야하는 최소 횟수


// 최소 힙 구현
class MinHeap {
  constructor() {
    this.heap = [null];
  }

  get size() {
    return this.heap.length - 1
  }

  get min() {
    return this.heap[1]
  }

  swap(idx1, idx2) {
    [this.heap[idx1], this.heap[idx2]] = [this.heap[idx2], this.heap[idx1]];
  }

  heappush(value) {
    this.heap.push(value)
    this.heapifyUp();
  }

  heapifyUp() {
    let idx = this.heap.length - 1;
    while (idx > 1 && this.heap[(idx / 2) >> 0] > this.heap[idx]) {
      this.swap((idx / 2) >> 0, idx);
      idx = (idx / 2) >> 0;
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
      let smallerChildIndex = idx * 2
      if (smallerChildIndex + 1 < this.heap.length && this.heap[smallerChildIndex + 1] < this.heap[smallerChildIndex]) {
        smallerChildIndex ++
      };

      if (this.heap[idx] <= this.heap[smallerChildIndex]) {
        break
      };
      this.swap(idx, smallerChildIndex);
      idx = smallerChildIndex
    }
  }

}


function solution(scoville, K) {
  const minHeap = new MinHeap

  scoville.forEach((el) => {
    minHeap.heappush(el)
  })
  // cnt 값
  let cnt = 0
  // 최소값이 K보다 작을 경우 계속 반복
  while (minHeap.min < K) {
    if (minHeap.size === 1) {
      if (minHeap.min < K) {
        cnt = -1
        break
      }
    }
    // 두 개 heappop 후에 스코빌 재계산
    const x = minHeap.heappop()
    const y = minHeap.heappop()
    const value = x + (y * 2)
    minHeap.heappush(value)
    cnt += 1
  }

  return cnt;
}