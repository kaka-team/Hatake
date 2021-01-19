package boot.spring.suanfa;

import java.util.Stack;

/**
 * @program: SSM
 * @description: 以字符串的形式读入两个数字，编写一个函数计算它们的和，以字符串形式返回。
 * （字符串长度不大于100000，保证字符串仅由'0'~'9'这10种字符组成）
 * @author: Hatake
 * @create: 2021-01-19 14:42
 **/
public class BigSum {
    public static void main(String[] args) {
        System.out.println(solve("1","100"));
    }
    public static String solve (String s, String t) {
        // write code here
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        Stack<String> dp = new Stack<>();
        for(int i = 0 ;i < s.length();i++){
            stack1.push(s.charAt(i));
        }
        for(int i = 0 ;i < t.length();i++){
            stack2.push(t.charAt(i));
        }
        int c = 0;
        while(!stack1.isEmpty()&&!stack2.isEmpty()){
            Character i = stack1.pop();
            Character j = stack2.pop();
            int temp = Integer.valueOf(i.toString()) + Integer.valueOf(j.toString()) + c;
            if(temp >= 10){
                c = temp / 10;
                dp.push(String.valueOf(temp % 10));
            }else{
                c = 0;
                dp.push(String.valueOf(temp));
            }
        }

        if(!stack1.isEmpty()){
            while(!stack1.isEmpty()){
                Integer temp = Integer.valueOf(stack1.pop().toString()) + c;
                if(temp >= 10){
                    c = temp / 10;
                    dp.push(String.valueOf(temp % 10));
                }else{
                    c = 0;
                    dp.push(String.valueOf(temp));
                }
            }
        }
        if(!stack2.isEmpty()){
            while(!stack2.isEmpty()){
                Integer temp = Integer.valueOf(stack2.pop().toString()) + c;
                if(temp >= 10){
                    c = temp / 10;
                    dp.push(String.valueOf(temp % 10));
                }else{
                    c = 0;
                    dp.push(String.valueOf(temp));
                }
            }
        }
        if(c > 0){
            dp.push(String.valueOf(c));
        }

        StringBuilder rs = new StringBuilder("");
        while (!dp.isEmpty()){
            rs.append(dp.pop());
        }
        return rs.toString();
    }
}
