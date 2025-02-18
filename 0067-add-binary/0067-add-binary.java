import java.util.*;

class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1;
        int carry = 0;

        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;
            if (i >= 0) {
                sum += a.charAt(i--) - '0';
            }
            if (j >= 0) {
                sum += b.charAt(j--) - '0';
            }
            sb.append(sum % 2);  // 3, 2, 1, 0의 결과가 나오는데 3, 1의 결과만 삽입
            carry = sum / 2;  // 3, 2인 경우 carry로 넘어가므로
        }

        String result = sb.reverse().toString();
        return result;
    }
}