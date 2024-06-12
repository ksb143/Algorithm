import java.util.Arrays;

class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        int len = phone_book.length;

        for (int i = 0; i < len - 1; i++) {
            String prefix = phone_book[i];
            String next = phone_book[i + 1];
            if (next.startsWith(prefix)) {
                return false;
            }
        }
        return true;
    }
}