function solution(citations) {
    const arr = Array(citations.length + 1).fill(0)
    // 비교 하기
    citations.forEach((el) => {
        if (el <= citations.length) {
            arr[el] += 1
        } else {
            arr[citations.length] += 1
        }
    })
    // 누적 합으로 만들기
    const accumArr = Array(citations.length + 1).fill(0)
    let temp = 0
    for (let i = citations.length; i >= 0; i--) {
        temp += arr[i]
        accumArr[i] += temp
        if (i <= accumArr[i]) {
            return i 
        }
    }
    
    return 0;
}