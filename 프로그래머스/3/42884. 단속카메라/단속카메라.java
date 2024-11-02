import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, Comparator.comparingInt(o -> o[1]));
        int cnt = 1;
        int cameraPlace = routes[0][1];
        for (int i = 1; i < routes.length; i++) {
            // 진입 시점이 현재 카메라위치보다 크면 새 카메라 필요
            if (cameraPlace < routes[i][0]) {
                // 새 카메라 도입
                cameraPlace = routes[i][1];
                cnt++;
            }
        }
        int answer = cnt;
        return answer;
    }
}