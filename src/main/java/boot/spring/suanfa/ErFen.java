package boot.spring.suanfa;

/**
 * @program: SSM
 * @description:
 * @author: Hatake
 * @create: 2020-12-08 20:55
 **/
public class ErFen {
    /**
     * 二分查找
     * @param n int整型 数组长度
     * @param v int整型 查找值
     * @param a int整型一维数组 有序数组
     * @return int整型
     */
    public int upper_bound_ (int n, int v, int[] a) {
        // write code here
        if(a[n-1] < v){
            return n+1;
        }
        int left = 0;
        int right = n - 1;
        while (left < right){
            int mid = left+(right - left)/2;
            if(a[mid] >= v){
                right = mid;
            }else {
                left = mid + 1;
            }

        }
        return left+ 1;

    }

    public int upper_bound_2 (int[] a,int target,int start,int end) {
        // write code here
        int mid = (start + end)/2;
        if (target < a[start] || target >a[end] || start > end){
            return -1;
        }
        if (a[mid] == target){
            return mid;
        }else if (a[mid] > target){
            return upper_bound_2(a,target,start,mid);
        }else {
            return upper_bound_2(a,target,mid,end);
        }

    }

}
