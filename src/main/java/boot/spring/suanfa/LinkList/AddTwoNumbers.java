package boot.spring.suanfa.LinkList;

/**
 * @program: SSM
 * @description:
 * @author: Hatake
 * @create: 2020-06-17 00:00
 **/
public class AddTwoNumbers {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null){
            return null;
        }
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        int addOne = 0;

        while(l1 != null || l2 != null || addOne != 0){
            int v1 = l1 == null?0:l1.val;
            int v2 = l2 == null?0:l2.val;
            int sum = (v1 + v2 + addOne) % 10;
            addOne = (v1 + v2 + addOne) / 10;
            ListNode curNode = new ListNode(sum);
            head.next = curNode;
            head = curNode;
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
        }
        return dummy.next;

    }
}
