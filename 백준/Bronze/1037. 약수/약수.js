const fs = require('fs')
const io = process.platform === "linux" ? "/dev/stdin" : "./input.txt"

// N의 진짜 약수 개수
// arr는 N의 진짜 약수
const [cnt, ...arr] = fs.readFileSync(io).toString().trim().split(/\s+/)
const numArr = arr.map(Number)

const maxValue = Math.max(...numArr)
const minValue = Math.min(...numArr)

const answer = maxValue * minValue

console.log(answer)
