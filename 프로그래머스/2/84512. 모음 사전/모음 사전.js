function generateDict(currWord, vowelDict, dict) {
  // 길이 넘어가면 중단
  if (currWord.length > 5) {
    return
  }
  // 가능한 단어 생성
  if (currWord.length > 0) {
    dict.push(currWord)
  }
  for (let i = 0; i < 5; i++) {
    generateDict(currWord + vowelDict[i], vowelDict, dict)
  }
}

function solution(word) {
  const vowelDict = ['A', 'E', 'I', 'O', 'U'];
  const dict = []
  generateDict('', vowelDict, dict)
  // 인덱스 찾기
  const ans = dict.indexOf(word) + 1

  return ans;
}
