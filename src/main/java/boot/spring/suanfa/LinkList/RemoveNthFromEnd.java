package boot.spring.suanfa.LinkList;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: SSM 快慢指针
 * @description: 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * 示例：  给定一个链表: 1->2->3->4->5, 和 n = 2.
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：  给定的 n 保证是有效的。  进阶：  你能尝试使用一趟扫描实现吗？
 * @author: Hatake
 * @create: 2020-06-27 23:56
 **/
public class RemoveNthFromEnd {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x){
            this.val = x;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        while (n != 0){
            fast = fast.next;
            n--;
        }
        while (fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
        /*ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;

        while (n != 0){
            fast = fast.next;
            n--;
        }

        while (fast.next != null){
            fast =fast.next;
            slow = slow.next;
        }
        slow.next =slow.next.next;
        return dummy.next;


*/





        /*Map<Integer,ListNode> map = new HashMap<>();
        int i = 1;
        ListNode dummy = head;
        if(head.next == null){
            map.put(i,head);
        }
        while(head.next != null){
            map.put(i,head);
            head = head.next;
            i++;
            if(head.next == null){
                map.put(i,head);
                break;
            }
        }

        int j = map.size() - n;
        if(j == 0){
            return head.next;
        }
        if(j == map.size() - 1){
            map.get(j).next = null;
            return dummy;
        }
        map.get(j).next = map.get(j + 1).next;
        return dummy;*/

        /*ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;

        while (n != 0){
            fast = fast.next;
            n--;
        }
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;*/
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        a.next = b;
        removeNthFromEnd(a,2);
    }


}
