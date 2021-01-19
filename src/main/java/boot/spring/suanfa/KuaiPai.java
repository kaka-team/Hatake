package boot.spring.suanfa;

/**
 * @program: SSM
 * @description:
 * @author: Hatake
 * @create: 2020-12-09 20:24
 **/
public class KuaiPai {
    public static void main(String[] args) {
        int[] numbers = {3,1,3,3,1,8,67,5};
        int start = 0;
        int end = 7;
        quickSort(numbers,start,end);
        for(int i =0;i<numbers.length;i++){
            System.out.print(numbers[i]+",");
        }
    }

    /**
     * 递推公式:
     * merge_sort(p...r) = merge(merge_sort(p...q), merge_sort(q+1...r))
     * 终止条件:
     * p >= r 不用再继续分解
     */
    public static void mergeSort(int[] numbers, int left, int right){
        if(left >= right){
            return;
        }
        int mid = left + (right - left) / 2;
        //分治递归
        mergeSort(numbers,left,mid);
        mergeSort(numbers,mid+1,right);
        //再合并
        merge(numbers,left,mid,right);
    }

    public static void merge(int[] numbers,int left,int mid,int right){
        //需要开辟额外的内存空间
        int[] temp = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int k = 0;
        //此时左右区间已经是排好序的 ->参考合并2个有序列表的做法
        while (i<=mid && j <=right){
            if(numbers[i] < numbers[j]){
                temp[k++] = numbers[i++];
            }else {
                temp[k++] = numbers[j++];
            }
        }
        while (i <= mid){
            temp[k++] = numbers[i++];
        }
        while (j <= right){
            temp[k++] = numbers[j++];
        }
        //覆盖原数组
        for(int x =0;x < temp.length;x++){
            numbers[left + x] = temp[x];
        }
    }

    /**
     * 作用是返回新的pivot下标，同时保证pivot左边的都比pivot小，右边的都比pivot大
     * 可以考虑从start 和end向pivot遍历，然后把大于pivot 小于pivot的放在2个数组里，然后合并，但是占用了额外空间
     * 所以优先考虑原地排序，不需要额外空间
     * @param numbers
     * @param start
     * @param end
     * @return
     */
    public static int partition(int[] numbers,int start,int end){

        int i = start;
        int pivot = numbers[end];
        for(int j = start; j< end ;j++){
            if(numbers[j] < pivot){
                int temp = numbers[i];
                numbers[i] = numbers[j];
                numbers[j] = temp;
                i++;
            }
        }
        int temp = numbers[end];
        numbers[end] = numbers[i];
        numbers[i] = temp;
        return i;




    /*    int pivot = numbers[end];
        int i = start;
        for (int j = start ; j< end ;j++){
            if(numbers[j] < pivot){
                int temp = numbers[j];
                numbers[j] = numbers[i];
                numbers[i] =temp;
                i++;
            }
        }
        int temp = numbers[end];
        numbers[end] = numbers[i];
        numbers[i] = temp;
        return i;*/
        /*//将最左边的元素暂时当作pivot
        //[start,i-1]是已经处理的区间，[i,end]是未处理区间，如果小于pivot,放在已处理区间尾部
        int pivot = numbers[end];
        int i  = start;
        //i j 都从左边开始 如果满足条件 j++ i不变
        for(int j = start;j<end;j++){
            if(numbers[j] < pivot){
                //如果发现小于pivot的，那么把number[i]跟number[j]交换位置 不断的把大的挪到i右边。
                // 如果遇到大于pivot的,i会停下指向大的数，而j会不停的往后走，直到碰到比pivot小的，这时候一交换，之前的大的刚好跟小的交换
                int temp = numbers[j];
                numbers[j] = numbers[i];
                numbers[i] = temp;
                i++;
            }
        }
        int temp = numbers[end];
        numbers[end] = numbers[i];
        numbers[i] = temp;
        //此时[i，end）往后都是大于pivot的，所以替换一下i end（pivot） 就可以了
        //新的分割点元素，从新的分割点，分别递归
        return i;*/
    }
    /**
     * 递推公式:
     * quick_sort(p...r) = quick_sort(p...q-1) + quick_sort(q+1, r)
     * 终止条件:
     * p >= r
     * @param numbers
     * @param start
     * @param end
     */
    public static void quickSort(int[] numbers, int start, int end) {
        if(start >= end){
            return;
        }
        int pivot = partition(numbers,start,end);
        quickSort(numbers,start,pivot-1);
        quickSort(numbers,pivot+1,end);

    }

    /**
     * 有一个整数数组，请你根据快速排序的思路，找出数组中第K大的数。
     *
     * 给定一个整数数组a,同时给定它的大小n和要找的K(K在1到n之间)，请返回第K大的数，保证答案存在。
     * @param a
     * @param n
     * @param K
     * @return
     */
    public int findKth(int[] a, int n, int K) {
        // write code here
        return findK(a,0,n-1,K);
    }

    public static int findK(int[] a  ,int start,int end,int k){
        if(start <= end ){
            int pivot = partition2(a,start,end);
            if(pivot == k - 1){
                return a[pivot];
            }else if(pivot < k - 1){
                return findK(a,pivot + 1,end,k);
            }else{
                return findK(a,start,pivot -1,k);
            }
        }
        return  -1;
    }

    public static int partition2(int[] a ,int start,int end){
        int pivot = a[end];
        int i = start;
        for(int j = start;i<end;j++){
            while (a[j] < pivot){
                int temp = a[j];
                a[j] = a[i];
                a[i] = temp;
                i++;
            }
        }
        int temp = a[end];
        a[end] = a[i];
        a[i] = temp;
        return i;
    }


}
