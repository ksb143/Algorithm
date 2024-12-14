import java.util.*;

class Solution {
    public boolean isPalindrome(String s) {
        List<Character> lst = new ArrayList<>();
        // 알파벳이면 넣기 (소문자 변환)
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '0')) {
                if (Character.isLetter(c)) {
                    lst.add(Character.toLowerCase(c));
                } else if (Character.isDigit(c)) {
                    lst.add(c);
                }
            }
        }
        // 빈 경우 혹은 하나인 경우 true 반환
        if (lst.isEmpty()) {
            return true;
        } else if (lst.size() == 1) {
            return true;
        } else {
            for (int i = 0; i < lst.size() / 2; i++) {
                char front = lst.get(i);
                char rear = lst.get(lst.size() - (i + 1));
                // 앞 뒤가 똑같지 않다면 바로 false 반환
                if (front != rear) {
                    return false;
                }

            }
        }
    // 만약 모든 경우를 통과한 경우 팰린드롬 형태이므로 true 반환
    return true;
    }
}