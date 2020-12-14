package boot.spring.suanfa.FastAndSlowPointer;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: SSM
 * @description: 给定一个链表，返回链表开始入环的第一个节点。
 *  如果链表无环，则返回 null。  为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。
 * @author: Hatake
 * @create: 2020-10-03 19:00
 **/
public class DetectCycle {
    /**
     * 暴力解法 o（n）
     * @param head
     * @return
     */
    public HasCycle.ListNode detectCycle1(HasCycle.ListNode head) {
        Set<HasCycle.ListNode> visited = new HashSet<>();
        HasCycle.ListNode cur = head;
        while (cur != null){
            if(visited.contains(cur)){
                return cur;
            }
            visited.add(cur);
            cur = cur.next;
        }
        return null;
    }

    /**
     * 快慢指针
     * @param head
     * @return
     */
    public HasCycle.ListNode detectCycle(HasCycle.ListNode head) {
        if(head == null || head.next == null){
            return null;
        }
        HasCycle.ListNode slow  = head;
        HasCycle.ListNode fast = head;
        while (true){
            if(fast == null || fast.next == null){
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                break;
            }
        }

        //slow = fast
        //fast此时运行的路程 = 2倍的slow   并且 此时慢指针 比 快指针少走了  1倍的路程= n圈的环长b  1s= nb
        //head到成环入口的地方距离为a，如果从head开始走，那么如果走a+nb步，正好就处于成环入口的地方，所以

        HasCycle.ListNode d1 = head;
        HasCycle.ListNode d2 = fast;

        while(d1 != d2){
            d1 = d1.next;
            d2 = d2.next;
        }
        return d1;



    }
}
