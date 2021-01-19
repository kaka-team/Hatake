package boot.spring.suanfa;

import java.util.Stack;

/**
 * @program: SSM
 * @description: 假设链表中每一个节点的值都在 0 - 9 之间，那么链表整体就可以代表一个整数。
 * 给定两个这种链表，请生成代表两个整数相加值的结果链表。
 * 例如：链表 1 为 9->3->7，链表 2 为 6->3，最后生成新的结果链表为 1->0->0->0。
 * @author: Hatake
 * @create: 2021-01-18 20:08
 **/
public class AddInList {
    public class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode addInList (ListNode head1, ListNode head2) {
        // write code here
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        while (head1!=null){
            stack1.push(head1.val);
            head1 = head1.next;
        }

        while (head2!=null){
            stack2.push(head2.val);
            head2 = head2.next;
        }

        ListNode dummy = new ListNode(0);
        int c = 0;
        while (!stack1.isEmpty() && !stack2.isEmpty()){
            int i = stack1.pop();
            int j = stack2.pop();
            ListNode t = new ListNode(0);
            int sum = i + j + c;
            if(sum >= 10){
                t.val = i + j + c - 10;
                c = 1;
            }else{
                t.val = i + j + c ;
                c= 0;
            }
            ListNode d = dummy.next;
            dummy.next = t;
            t.next = d;
        }
        //0,0,0,0,0,0,0,4,2,8,3,5,1,0,5,7,4,5,0,2,5,0,3,9,7,3,6,8,4,4,9,7,1
        //5,9,2,3,7,4,9,9,0,2,6,6,1,3,8,3,2,1,9,8,4,3,1,3,3,7,5,3,9,3,1,3,1
        if(!stack1.isEmpty()){
            while (!stack1.isEmpty()){
                ListNode t = new ListNode(0);
                int temp = stack1.pop() + c;
                if(temp  >= 10){
                    t.val = temp - 10;
                    c = 1;
                }else{
                    t.val = temp;
                    c = 0;
                }
                ListNode d = dummy.next;
                dummy.next = t;
                t.next = d;
            }
            if(c != 0){
                ListNode t = new ListNode(1);
                ListNode d = dummy.next;
                dummy.next = t;
                t.next = d;
            }
        }
        if(!stack2.isEmpty()){
            while (!stack2.isEmpty()){
                ListNode t = new ListNode(0);
                int temp = stack2.pop() + c;
                if(temp  >= 10){
                    t.val = temp - 10;
                    c = 1;
                }else{
                    t.val = temp;
                    c = 0;
                }
                ListNode d = dummy.next;
                dummy.next = t;
                t.next = d;
            }
            if(c != 0){
                ListNode t = new ListNode(1);
                ListNode d = dummy.next;
                dummy.next = t;
                t.next = d;
            }
        }

        return dummy.next;

    }
}
