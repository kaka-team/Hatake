package boot.spring.po;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("演员表")
public class Actor implements Serializable{
	@ApiModelProperty("主键")
	private long actor_id;
	@ApiModelProperty("名字")
	private String first_name;
	@ApiModelProperty("姓氏")
	private String last_name;
	@ApiModelProperty("最后更新日期")
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
