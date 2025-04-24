
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
import java.util.*;

public class Solution {
    public boolean hasCycle(ListNode head) {
        int count = 0;
        while (count <= 10000) {
            if (head == null) {
                return false;
            }
            head = head.next;
            count++;
        }
        return true;
    }
}