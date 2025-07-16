import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        HashMap<String, HashSet> reportList = new HashMap<>();
        HashMap<String, Integer> reportNum = new HashMap<>();
        HashMap<String, Integer> mailNum = new HashMap<>();
        // 맵에 유저 이름 넣기
        for (String id : id_list) {
            HashSet<String> set = new HashSet<>();
            reportList.put(id, set);
            reportNum.put(id, 0);
            mailNum.put(id, 0);
        }
        // 신고 맵에 부여
        for (String r : report) {
            String[] reportArr = r.split(" ");
            String reporter = reportArr[0];  // 신고자
            String user = reportArr[1];  // 피신고자

            HashSet<String> reportedSet = reportList.get(reporter);
            if (reportedSet.contains(user)) {
                continue;
            }

            reportedSet.add(user);  // 해당 사람 세트에 추가
            reportList.put(reporter, reportedSet);  // 맵 매칭
            reportNum.put(user, reportNum.get(user) + 1);  // 사람 수 늘리기

        }
        // 신고횟수 둘러보기
        for (Map.Entry<String, Integer> entry1 : reportNum.entrySet()) {
            int val = entry1.getValue();
            // 신고 개수가 k개 이상이면
            if (val >= k) {
                for (Map.Entry<String, HashSet> entry2 : reportList.entrySet()) {
                    // 기준 이상이 해당 엔트리에 포함되어 있으면
                    if (entry2.getValue().contains(entry1.getKey())) {
                        mailNum.put(entry2.getKey(), mailNum.get(entry2.getKey()) + 1);  // 발송받을 사람 +1
                    }
                }
            }
        }
        
        int[] answer = new int[id_list.length];
        for (int i = 0; i < id_list.length; i++) {
            String id = id_list[i];
            answer[i] = mailNum.get(id);
        }



        return answer;
    }
}