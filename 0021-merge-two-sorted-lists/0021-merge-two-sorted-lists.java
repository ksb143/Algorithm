import java.util.*;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    // 리스트를 연결리스트 노드로 만드는 메소드
    public static ListNode listToListNode(List<Integer> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        ListNode head = new ListNode(list.get(0));
        ListNode curr = head;
        for (int i = 1; i < list.size(); i++) {
            curr.next = new ListNode(list.get(i));
            curr = curr.next;
        }
        return head;
    }
    // 연결 리스트를 리스트로 만드는 메소드
    public static List<Integer> listNodeToList(ListNode list) {
        List<Integer> lst = new ArrayList<>();
        ListNode curr = list;
        while (curr != null) {
            lst.add(curr.val);
            curr = curr.next;
        }
        return lst;
    }
    // 두 연결 리스트를 합쳐서 정렬한 연결 리스트로 만드는 메소드
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        List<Integer> lst1 = listNodeToList(list1);
        List<Integer> lst2 = listNodeToList(list2);
        lst1.addAll(lst2);
        Collections.sort(lst1);
        ListNode answer = listToListNode(lst1);
        return answer;
    }
}