package boot.spring.suanfa;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: SSM
 * @description:给定一个经过编码的字符串，返回它解码后的字符串。
 *
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 *
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 *
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。

 * @author: Hatake
 * @create: 2020-09-17 21:24
 **/
public class DecodeString {
    //当前指针位置
    static int  ptr;
    //入栈法
    public static String decodeString(String s) {
        //栈
        LinkedList<String> stack = new LinkedList<>();
        //
        while (ptr < s.length()){
            //当前字符
            char current = s.charAt(ptr);
            //如果是数字 3[a2[c]]
            //此时cur = 3 直接进栈  [3]
            if(Character.isDigit(current)){
                //防止出现多位数字
                StringBuilder temp = new StringBuilder();
                while(Character.isDigit(s.charAt(ptr))){
                    temp.append(s.charAt(ptr));
                    ptr++;
                }
                stack.addLast(temp.toString());
            }else  if(Character.isLetter(current) || current == '['){
                //如果此时的字符为字母，或者为左括号，直接进栈
                //此时cur = [  直接进 {3,[ }
                //此时cur = a {3 , [ , a }
                //一直到 cur = c 的时候 {3 [ a 2 [ c }
                //然后遇到了第一个]，这个时候开始出栈，一直到遇见左括号  这期间取出的字符串组合 就是 应该翻倍的字符串  而左括号前一定是个数字，这是保证的
                stack.addLast(String.valueOf(current));
                ptr++;
            }else {
                //用于存储出栈的字符串
                LinkedList<String> tempStr = new LinkedList<>();
                //直到寻找到[ ,此时
                while (!"[".equals(stack.peekLast())){
                    tempStr.addLast(stack.removeLast());
                }
                Collections.reverse(tempStr);//翻转一下，因为从栈出的字符添加进来是反的

                StringBuilder shortStr = new StringBuilder();
                tempStr.forEach(ele ->{
                    shortStr.append(ele);
                });

                //然后将左括号出战
                stack.removeLast();
                //此时栈顶必为数字，也就是应该出现的次数
                int showTimes = Integer.parseInt(stack.removeLast());
                StringBuilder repeatStr = new StringBuilder();
                while (showTimes-- > 0){
                    repeatStr.append(shortStr);
                }
                stack.addLast(repeatStr.toString());
                ptr++;

            }
        }
        StringBuffer ret = new StringBuffer();
        for (String ss : stack) {
            ret.append(ss);
        }
        return ret.toString();

    }

    static String src;
    //递归法
    public  static String decodeString2(String s) {
        ptr = 0;
        src = s;
        return  getString();
    }
    //递归的思想就是 每次当作一次正常的逻辑处理 3[a2[c]] 比如这个
    //如果不考虑嵌套括号，那么正常的逻辑就是 如果是数字，那么数字 后面的 左括号舍弃 右括号舍弃 中间的字符串就是需要 重复显示的
    //所以此处就对应*处的代码，因为在嵌套环境中，此处的字符串并不是纯字母，所以需要继续处理
    public static String getString(){
        //执行完毕或者遇到了右括号 就不再处理
        if(ptr == src.length() || src.charAt(ptr) == ']' ){
            return "";
        }
        char cur = src.charAt(ptr);
        StringBuilder rt = new StringBuilder();
        //存储的是每次处理后的字符串  3[a2[c]]
        String shortStr = "";
        //如果是数字,那么把数字拼接好
        if(Character.isDigit(cur)){
            //如果一直是数字，拼接数字
            while (ptr < src.length() && Character.isDigit(src.charAt(ptr))) {
                rt = rt.append(src.charAt(ptr++));
            }
            //此时ptr一定指向左括号，跳过
            ptr++;
            //这时候开始解析字符串
            //比如3 [  ，那么说明 需要 重复3次 后面的逻辑  *
            String str = getString();
            //因为这个方法遇到了右括号则跳出，那么这里需要再跳过右括号，继续处理
            ptr++;
            int repeatTimes = Integer.valueOf(rt.toString());
            while (repeatTimes-- > 0) {
                shortStr += str;
            }

        }else if(Character.isLetter(cur)){
            //如果是字母，那么直接拼接
            shortStr+= src.charAt(ptr++);
        }
        //这里的shortstr代表的就是此时拼接的临时字符串 比如2[ab2[c]]  此时shortstr是ab 再次getString后，才是abcc 然后再跳回上层， 最外层的shortStr = ''，直接就
        return shortStr + getString();


    }

    public static void main(String[] args) {
        System.out.println(decodeString2("3[a]2[bc]"));
    }

}
