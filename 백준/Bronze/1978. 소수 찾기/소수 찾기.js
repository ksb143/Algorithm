const fs = require('fs');
const io = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const [n, ...arr] = fs.readFileSync(io).toString().trim().split(/\s+/).map(Number);

function isPrime(value) {
  if (value === 1) return false;
  for (let i = 2; i <= Math.sqrt(value); i++) {
    if (value % i === 0) {
      return false;
    }
  }
  return true;
}

let cnt = 0;

arr.forEach((el) => {
  if (isPrime(el)) {
    cnt++;
  }
});

console.log(cnt);