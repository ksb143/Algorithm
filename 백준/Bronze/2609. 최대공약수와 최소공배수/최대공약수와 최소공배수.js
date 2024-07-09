const fs = require('fs')
const io = process.platform === "linux" ? "/dev/stdin" : './input.txt';

const [a, b] = fs.readFileSync(io).toString().trim().split(' ').map(Number)

// 유클리드 호제법
const value = [a, b]
value.sort((x, y) => {
  return x - y
})
let smallValue = value[0]
let bigValue = value[1]
while (true) {
  let reminder = bigValue % smallValue
  if (reminder === 0) {
    break
  }
  bigValue = smallValue
  smallValue = reminder
}

const gcd = smallValue
const lcm = a * b / smallValue 


console.log(gcd)
console.log(lcm)