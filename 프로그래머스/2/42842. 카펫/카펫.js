// 약수 구하는 함수
function findGcd(num) {
  const arr = []
  for (let i = 1; i <= Math.sqrt(num); i++) {
    if (num % i === 0) {
      arr.push(i)
    }
  }
  return arr
}

function solution(brown, yellow) {
  // 약수 구하기
  const gcd = findGcd(yellow)
  const result = [0, 0]
  for (i = 0; i < gcd.length; i++) {
    let l = gcd[i]
    let w = yellow / l
    let temp = 4 + (2 * l) + (2 * w)
    if (temp === brown) {
      result[0] = w + 2
      result[1] = l + 2
      break
    }
  }
  return result
}