
import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        List<String> arr = new ArrayList<>();
        int time = 0;

        if (cacheSize == 0) {
            return cities.length * 5;
        }

        for (String city : cities) {
            city = city.toLowerCase();
            // 해당 도시 있다면
            if (arr.contains(city)) {
                arr.remove(city);  // 해당 도시 지우기
                time += 1;  // 캐시히트
            } else {
                time += 5;  // 캐시미스
                if (arr.size() >= cacheSize) {
                    arr.remove(0);  // 예전 도시 지우기
                } 
            }
            arr.add(city);  // 도시 넣기
        }

        return time;
    }
}