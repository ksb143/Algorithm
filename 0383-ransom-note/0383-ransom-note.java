class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        // 랜섬노트의 문자를 가지고 맵 만들기
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < ransomNote.length(); i++) {
            // 해당 문자에 해당하는 키가 있다면 값 증가, 없으면 키 만들기
            char c = ransomNote.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        // 랜섬노트랑 비교
        for (int i = 0; i < magazine.length(); i++) {
            // 랜섬노트에 해당하는 키가 있다면 값 감소, 없으면 넘어가기
            char c = magazine.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                // 해당 문자를 가진 키의 개수가 0인 경우 키 없애기
                if (map.get(c) == 0) {
                    map.remove(c);
                }
            }
        }
        // 랜섬노트에 키가 남은 경우 매거진 글씨로 랜섬노트를 만들 수 없으므로 false
        if (map.size() == 0) {
            return true;
        } else {
            return false;
        }
    }
}