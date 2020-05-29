package boot.spring.controller;

/**
 * @program: SSM
 * @description:
 * @author: Hatake
 * @create: 2019-08-10 21:09
 **/
public class Test {
    static class X{
        Integer value;
    }
    public static void add(int a,X x){
        a = a + a;
        x.value = x.value + a;
    }

    public static void main(String[] args) {
        int a = 1;
        X x = new X();
        x.value = 1;

        Test.add(a,x);
        System.out.println("a:" + a);
        System.out.println("x:" + (x.value + a));
    }

}
