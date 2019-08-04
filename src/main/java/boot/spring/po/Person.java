package boot.spring.po;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: SSM
 * @description:
 * @author: Simida
 * @create: 2019-08-04 11:43
 **/
public class Person implements Serializable {
    private long actor_id;

    private String first_name;

    private String last_name;

    private Date last_update;

    public long getActor_id() {
        return actor_id;
    }

    public void setActor_id(long actor_id) {
        this.actor_id = actor_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Date getLast_update() {
        return last_update;
    }

    public void setLast_update(Date last_update) {
        this.last_update = last_update;
    }
}

