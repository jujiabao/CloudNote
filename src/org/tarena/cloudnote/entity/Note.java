package org.tarena.cloudnote.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Note implements Serializable {
	private String cn_note_id;
	private String cn_notebook_id;
	private String cn_user_id;
	private String cn_note_status_id;
	private String cn_note_type_id;
	private String cn_note_title;
	private String cn_note_body;
	private Long cn_note_create_time;
	private Long cn_note_last_modify_time;
	
	//追加格式化日期显示的方法
	//转为json时，会根据get方法生成json的key值
	public String getCreateTime(){
		if (cn_note_create_time == null || "".equals(cn_note_create_time)) {
			return "";
		}
		try {
			Date date = new Date(cn_note_create_time);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			return sdf.format(date);
		} catch (Exception e) {
			return "";
		}
	}
	
	public String getCn_note_id() {
		return cn_note_id;
	}
	public void setCn_note_id(String cn_note_id) {
		this.cn_note_id = cn_note_id;
	}
	public String getCn_notebook_id() {
		return cn_notebook_id;
	}
	public void setCn_notebook_id(String cn_notebook_id) {
		this.cn_notebook_id = cn_notebook_id;
	}
	public String getCn_user_id() {
		return cn_user_id;
	}
	public void setCn_user_id(String cn_user_id) {
		this.cn_user_id = cn_user_id;
	}
	public String getCn_note_status_id() {
		return cn_note_status_id;
	}
	public void setCn_note_status_id(String cn_note_status_id) {
		this.cn_note_status_id = cn_note_status_id;
	}
	public String getCn_note_type_id() {
		return cn_note_type_id;
	}
	public void setCn_note_type_id(String cn_note_type_id) {
		this.cn_note_type_id = cn_note_type_id;
	}
	public String getCn_note_title() {
		return cn_note_title;
	}
	public void setCn_note_title(String cn_note_title) {
		this.cn_note_title = cn_note_title;
	}
	public String getCn_note_body() {
		return cn_note_body;
	}
	public void setCn_note_body(String cn_note_body) {
		this.cn_note_body = cn_note_body;
	}
	public Long getCn_note_create_time() {
		return cn_note_create_time;
	}
	public void setCn_note_create_time(Long cn_note_create_time) {
		this.cn_note_create_time = cn_note_create_time;
	}
	public Long getCn_note_last_modify_time() {
		return cn_note_last_modify_time;
	}
	public void setCn_note_last_modify_time(Long cn_note_last_modify_time) {
		this.cn_note_last_modify_time = cn_note_last_modify_time;
	}
	
	@Override
	public String toString() {
		return "Note [cn_note_id=" + cn_note_id + ", cn_notebook_id="
				+ cn_notebook_id + ", cn_user_id=" + cn_user_id
				+ ", cn_note_status_id=" + cn_note_status_id
				+ ", cn_note_type_id=" + cn_note_type_id + ", cn_note_title="
				+ cn_note_title + ", cn_note_body=" + cn_note_body
				+ ", cn_note_create_time=" + cn_note_create_time
				+ ", cn_note_last_modify_time=" + cn_note_last_modify_time
				+ "]";
	}
}
