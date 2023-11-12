package com.smiple.crud.mytest.simplecrud;

import java.io.Serializable;
import java.util.Calendar;

public class DataDTO implements Serializable {

	private static final long serialVersionUID = -806096673546244976L;
	
	Integer id;
	String created;
	String name;
	String content;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
}
