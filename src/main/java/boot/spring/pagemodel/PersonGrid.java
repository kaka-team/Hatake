package boot.spring.pagemodel;

import boot.spring.po.Person;

import java.util.List;

/**
 * @program: SSM
 * @description:
 * @author: Simida
 * @create: 2019-08-04 12:23
 **/
public class PersonGrid {

    private int current;//当前页面号
    private int rowCount;//每页行数
    private int total;//总行数
    private List<Person> rows;

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public int getRowCount() {
        return rowCount;
    }

    public void setRowCount(int rowCount) {
        this.rowCount = rowCount;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<Person> getRows() {
        return rows;
    }

    public void setRows(List<Person> rows) {
        this.rows = rows;
    }
}

