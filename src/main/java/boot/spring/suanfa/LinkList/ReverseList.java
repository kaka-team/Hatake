package boot.spring.suanfa.LinkList;


import java.util.Arrays;

/**
 * @program: SSM
 * @description:反转一个单链表
 * @author: Hatake
 * @create: 2020-10-07 19:40
 **/
public class ReverseList {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }
    //null  1 -> 2 -> 3

    public ListNode reverseList2(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre.next;
    }








    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    /**
     * 反转字符串
     * @param str string字符串
     * @return string字符串
     */
    public String solve (String str) {
        // write code here
        char[] chars = str.toCharArray();
        int mid = str.length()/2;
        for(int i = 0;i<mid;i++){
            char temp = chars[str.length() - 1 - i];
            chars[str.length() - 1 - i] = chars[i];
            chars[i] = temp;
        }
        return new String(chars);
    }

}


































