function solution(bridge_length, weight, truck_weights) {
  // 다리 길이만큼 0으로 채운 배열 만들기
  let bridge = Array(bridge_length).fill(0)
  let current_weight = 0;  // 현재 다리 위 무게
  let current_time = 0;  // 현재 시간
  // 대기 중이 트럭이 있거나 현재 다리를 건너는 트럭이 있으면
  while (truck_weights.length > 0 || current_weight > 0) {
    // 시간 증가
    current_time += 1
    // 다리에 있는 트럭 앞으로 보내고 그만큼 무게 제거
    current_weight -= bridge.shift()
    // 대기 트럭이 있고 대기 트럭 가장 첫 트럭 무게가 감당 무게 안이면
    if (truck_weights) {
      if (truck_weights[0] + current_weight <= weight) {
        let truck = truck_weights.shift()
        bridge.push(truck)
        current_weight += truck
      } else {
      bridge.push(0)
      }
    }
  }
  return current_time;
}