package boot.spring.suanfa;

/**
 * @program: SSM
 * @description: 将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * 示例：  输入：1->2->4, 1->3->4 输出：1->1->2->3->4->4
 * @author: Hatake
 * @create: 2020-05-01 20:32
 **/
public class MergeTwoLists {


    public static void main(String[] args) {
        int A[] = {1, 2, 3};
        int B[] = {2, 5, 6};
        merge2Array(A, 6, B, 3);
        for (int i = 0; i < A.length; i++) {
            System.out.println(A[i]);
        }
    }

    public static void merge2Array(int A[], int m, int B[], int n) {
        int leftptr = m - 1;
        int rightptr = n - 1;
        for (int dummyptr = m + n - 1; leftptr >= 0 && rightptr >= 0; dummyptr--) {
            A[dummyptr] = A[leftptr] > B[rightptr] ? A[leftptr--] : B[rightptr--];
        }
        while (rightptr >= 0) {
            A[rightptr] = B[rightptr--];
        }
    }

    //合并2个有序数组
    public static void merge(int A[], int m, int B[], int n) {
        if (m == 0) {
            for (int i = 0; i < B.length; i++) {
                A[i] = B[i];
            }
            return;
        }
        int[] temp = new int[m + n];
        int left = 0;
        int right = 0;
        int k = 0;
        while (left < m && right < n) {
            if (A[left] < B[right]) {
                temp[k++] = A[left++];
            } else {
                temp[k++] = B[right++];
            }
        }
        while (left < m) {
            temp[k++] = A[left++];
        }
        while (right < n) {
            temp[k++] = B[right++];
        }
        for (int i = 0; i < temp.length; i++) {
            A[i] = temp[i];
        }
    }

    //每次返回的都是两个节点中
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //创建一个头节点
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        //如果某个node是null，则可以将另外一个链表的所有node append,即可跳出循环
        while (l1 != null && l2 != null) {
            //如果l1的val小
            if (l1.val < l2.val) {
                //则将head的next指向l1，说明该节点数据目前是最小的，将该节点加入链表中
                head.next = new ListNode(l1.val);
                //l1指向后一个节点，再由l1后一个节点与l2进行比较
                l1 = l1.next;
            } else {
                head.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            //比如经历第一次比较后 新链表中原本只有 【0】，后变成【0，1】 head指向1
            head = head.next;
        }
        if (l1 != null) {
            head.next = l1;
        }
        if (l2 != null) {
            head.next = l2;
        }
        return dummy.next;
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}