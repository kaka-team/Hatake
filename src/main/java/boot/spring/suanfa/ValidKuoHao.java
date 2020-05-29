package boot.spring.suanfa;

import java.util.*;

/**
 * @program: SSM
 * @description:
 * @author: Hatake
 * @create: 2020-05-21 23:23
 **/
public class ValidKuoHao {
    public static void main(String[] args) {
        System.out.println(isValid("{[(]}"));
    }

    public static boolean isValid(String s) {
        Map<Character,Character> map  = new HashMap<>();
        map.put('}','{');
        map.put(']','[');
        map.put(')','(');

        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        if(chars.length <= 0){
            return true;
        }
        for(int i = 0;i < chars.length;i++){
            //如果是右括号，判断stack的顶部是否存在对应的左括号，如果
            if(map.containsKey(chars[i])){
                Character top = stack.pop();
                //如果头部元素等于该右括号对应的左括号，说明语法合法
                if(top.equals(map.get(chars[i]))){
                    continue;
                }else{
                    return false;
                }
            }else{
                 stack.push(chars[i]);
            }
        }
        return stack.isEmpty();
    }
}
