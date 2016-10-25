package bean;

import javax.inject.Named;

@Named
public class UserBean {
	
	private String name;
	private String surename;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurename() {
		return surename;
	}
	public void setSurename(String surename) {
		this.surename = surename;
	}
	
	

}
