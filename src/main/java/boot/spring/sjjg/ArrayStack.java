package boot.spring.sjjg;

/**
 * @program: SSM
 * @description: 顺序栈
 * @author: Hatake
 * @create: 2020-03-17 22:39
 **/
public class ArrayStack {
    private String[] items;
    private int count;
    private int n;


    public ArrayStack(String[] items, int count, int n) {
        this.items = items;
        this.count = count;
        this.n = n;
    }


    public boolean push(String item){
        if(count == n){
            return false;
        }
        items[count] = item;
        ++count;
        return true;
    }

    public String pop(){
        if(count == 0){
            return null;
        }
        String temp = items[count - 1] ;
        --count;
        return temp;
    }

    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(new String[]{"123","222"},2,5);
        System.out.println(arrayStack.pop());
    }

}
