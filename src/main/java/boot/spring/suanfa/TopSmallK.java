package boot.spring.suanfa;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @program: SSM
 * @description:
 * @author: Hatake
 * @create: 2021-01-05 22:03
 **/
public class TopSmallK {
    //可以用堆排序思想
    //或者快排
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        if(input.length < k || k == 0){
            return new ArrayList<>();
        }
        //大顶堆存的是最小的k个数 。默认小顶堆
        Queue<Integer> queue = new PriorityQueue<>(k,(a,b)->(b-a));
        for (int i = 0 ;i < input.length;i++){
            if(queue.size()<k){
                queue.add(input[i]);
            }else{
                //每次与堆顶数字比较，如果小于堆顶数字，那么替换
                if(queue.peek() > input[i]){
                    queue.poll();
                    queue.add(input[i]);
                }
            }
        }
        ArrayList<Integer> ls = new ArrayList<>();
        ls.addAll(queue);
        return ls;
    }
}
