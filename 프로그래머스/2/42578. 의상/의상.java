import java.util.HashMap;
import java.util.ArrayList;

class Solution {
    public int solution(String[][] clothes) {
        // 해시맵 생성
        HashMap<String, ArrayList<String>> map = new HashMap<>();

        // 옷 종류별로 순회하면서 값 추가
        for (String[] cloth : clothes) {
            // 키 존재하지 않으면 새 키 생성
            // containsKey 메서드 (해시맵에 특정 키가 있는지 확인)
            if (!map.containsKey(cloth[1])) {
                // put 메서드 (해시맵에 키와 값을 추가)
                map.put(cloth[1], new ArrayList<>());
            }
            // 키에 해당하는 ArrayList에 값 추가
            // get 메서드 (key에 해당하는 value 반환)
            // add 메서드 (ArrayList에 값 추가)
            map.get(cloth[1]).add(cloth[0]);
        }

        // 경우의 수 계산
        int answer = 1;
        // keySet 메서드 (해시맵의 키 반환)
        for (String key : map.keySet()) {
            // size 메서드 (ArrayList의 크기 반환)
            answer *= map.get(key).size() + 1;
        }
        answer -= 1;
        return answer;
    }
}