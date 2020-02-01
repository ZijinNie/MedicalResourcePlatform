package mchacks9.wuhan.model;

import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity

public class Hospital {
	private long hId;
	private String username;
	private String password;
	private String name;
	private String city;
	private String state;
	private String strAddr;
	private String description;
	private String contact;
	private List<Request> requests;
	
	public Hospital() {
		
	}
	public Hospital(String username, String password, String name, String city,String state, String strAddr,  String description, String contact) {
		this.username = username;
		this.password = password;
		this.city = city;
		this.state = state;
		this.strAddr = strAddr;
		this.name = name;
		this.description = description;
		this.setContact(contact);
		this.hId = new Random().nextLong();
	}
	
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	@OneToMany(cascade = { CascadeType.ALL })
	public List<Request> getRequests() {
		return requests;
	}

	public void setRequests(List<Request> requests) {
		this.requests = requests;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStrAddr() {
		return strAddr;
	}

	public void setStrAddr(String strAddr) {
		this.strAddr = strAddr;
	}


	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}
	@Id
	public long gethId() {
		return hId;
	}
	public void sethId(long hId) {
		this.hId = hId;
	}
}
