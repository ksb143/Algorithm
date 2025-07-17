import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Set<String>> reportedByMap = new HashMap<>();  // key: 피신고자, value: 신고자 목록
        Map<String, Integer> mailCount = new HashMap<>();

        for (String id : id_list) {
            reportedByMap.put(id, new HashSet<>());
            mailCount.put(id, 0);
        }

        // 1. 중복 제거
        Set<String> reportSet = new HashSet<>(Arrays.asList(report));

        // 2. 신고 정보 기록
        for (String r : reportSet) {
            String[] parts = r.split(" ");
            String reporter = parts[0];
            String reported = parts[1];
            reportedByMap.get(reported).add(reporter);
        }

        // 3. k 이상 신고된 유저의 신고자에게 메일 발송
        for (String reported : reportedByMap.keySet()) {
            Set<String> reporters = reportedByMap.get(reported);
            if (reporters.size() >= k) {
                for (String reporter : reporters) {
                    mailCount.put(reporter, mailCount.get(reporter) + 1);
                }
            }
        }

        // 4. 결과 배열 만들기
        int[] answer = new int[id_list.length];
        for (int i = 0; i < id_list.length; i++) {
            answer[i] = mailCount.get(id_list[i]);
        }

        return answer;
    }
}
