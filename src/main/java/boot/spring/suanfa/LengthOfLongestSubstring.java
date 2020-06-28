package boot.spring.suanfa;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @program: SSM
 * @description: 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度
 * 一般涉及到出现次数，用hashset
 * 涉及子串，滑动窗口
 * @author: Hatake
 * @create: 2020-05-02 23:44
 **/
public class LengthOfLongestSubstring {


    public static int other(String s){
        if (s.length()==0) return 0;
        Map<Character,Integer> map = new HashMap<>();
        int left = 0;
        int max = 0;
        int n = s.length();
        for(int i = 0 ; i < n;i++){
            //说明该字符已经出现过，可以把该字符左侧的字符都抛弃
            if(map.containsKey(s.charAt(i))){
                //移动窗口左边至上次出现该字符的右侧，刚好排除第一次出现该字符的位置 与 现在的left比较 如果目前left比较大，说明已经越过上次重复的字符，直接覆盖就好
                // a b b a  n = 3 map(a->0,b->2) 这个时候Left已经指在2了，a等于已经处理过
                left = Math.max(map.get(s.charAt(i)) + 1,left);
            }
            //记录出现的index
            map.put(s.charAt(i),i);
            max = Math.max(max,i - left + 1);
            System.out.println();
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(other("abba"));
    }



    //a b c a c d a b
    //从a开始向后遍历，直达出现与之前子串重复的  第一轮到abc set存储的是 abc max=3
    //第二轮从b开始，左指针指向b，set里变成了bc，结束时，到bcacd，set存储的是 bcacd max=5
    //第三轮从c开始，左指针指向c......
    public int lengthOfLongestSubstring(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, max = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            max = Math.max(max, rk - i + 1);
        }
        return max;
    }
}
