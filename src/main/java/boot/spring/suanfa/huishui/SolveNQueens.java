package boot.spring.suanfa.huishui;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @program: SSM
 * @description:
 * @author: Hatake
 * @create: 2020-08-07 00:07
 **/
public class SolveNQueens {
    List<List<String>> res = new ArrayList<>();
    int t = 0;
    public  List<List<String>> solveNQueens(int n) {
        List<List<String>> dummy = new ArrayList<>();
        for (int i =0;i<n;i++){
            List<String > t = new ArrayList<>();
            for (int j =0;j<n;j++){
                t.add(".");
            }
            dummy.add(t);
        }
        t = n;
        chooseQueue(dummy,0);
        return res;
    }

    public  void chooseQueue(List<List<String>> hasChoose/*已做选择*/,int row /*路径*/){
        if(t == row){
            List<List<String>> dummy = new ArrayList<>();
            for (int i =0;i<t;i++){
                List<String > temp = new ArrayList<>();
                for (int j =0;j<t;j++){
                    temp.add(hasChoose.get(i).get(j));
                }
                dummy.add(temp);
            }
            res = dummy;
            return;
        }
        int n = hasChoose.size();
        for (int i = 0;i < n ;i++){
            if(!check(hasChoose,row,i)){
                continue;
            }
            hasChoose.get(row).set(i,"Q");
            chooseQueue(hasChoose,row + 1);
            hasChoose.get(row).set(i,".");
        }
    }
    public  boolean check(List<List<String>> hasChoose,int x,int y){
        boolean flag = true;
        int n = hasChoose.size();
        for (int i = 0;i < n;i++){
            if(hasChoose.get(i).get(y).equals("Q")){
                flag = false;
            }
        }
        for (int i = x - 1,j = y + 1;i>= 0 && j < n;i--,j++){
            if(hasChoose.get(i).get(j) == "Q"){
                flag = false;
            }
        }
        for (int i = x - 1,j = y - 1;i>= 0 && j >= 0;i--,j--){
            if(hasChoose.get(i).get(j) == "Q"){
                flag = false;
            }
        }
        return flag;
    }


}
