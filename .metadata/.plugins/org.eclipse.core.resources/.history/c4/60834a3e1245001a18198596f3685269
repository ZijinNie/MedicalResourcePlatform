package mchacks9.wuhan.model;

import java.util.Random;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity

public class Hospital {
	private long hid;
	private String username;
	private String password;
	private String name;
	private String location;
	private String description;
	private int phonenum;
	private Set<Request> requests;
	
	public Hospital(String username, String password, String name, String location, String description, int phonenum) {
		super();
		this.hid = new Random(999).nextLong();
		this.username = username;
		this.password = password;
		this.name = name;
		this.location = location;
		this.description = description;
		this.phonenum = phonenum;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPhonenum() {
		return phonenum;
	}
	public void setPhonenum(int phonenum) {
		this.phonenum = phonenum;
	}
	@Id
	public long getHid() {
		return hid;
	}
	
	@OneToMany(cascade = { CascadeType.ALL })
	public Set<Request> getRequests() {
		return requests;
	}

	public void setRequests(Set<Request> requests) {
		this.requests = requests;
	}


}
