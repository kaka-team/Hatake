package boot.spring.suanfa;

/**
 * @program: SSM
 * @description:
 * @author: Hatake
 * @create: 2021-01-07 17:12
 **/
public class TiaoTaiJie {
    //理解为斐波那契
    public int JumpFloor(int target) {
        if(target <= 1){
            return 1;
        }
        return JumpFloor(target - 1) + JumpFloor(target - 2);
    }
}
