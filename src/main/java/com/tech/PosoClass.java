package com.tech;

public class PosoClass {
	
	String name;
	String email;
	int pass;
	int contact;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPass() {
		return pass;
	}
	public void setPass(int pass) {
		this.pass = pass;
	}
	public int getContact() {
		return contact;
	}
	public void setContact(int contact) {
		this.contact = contact;
	}
	@Override
	public String toString() {
		return "PosoClass [name=" + name + ", email=" + email + ", pass=" + pass + ", contact=" + contact + "]";
	}
	
	

}
