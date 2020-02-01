package mchacks9.wuhan.dto;

import java.util.ArrayList;
import java.util.List;



public class HospitalDto {

	private String username;
	private String password;
	private String name;
	private String city;
	private String state;
	private String strAddr;
	private String description;
	private String contact;
	private List<RequestDto> requests;
	
	
	//Constructors
	
	public HospitalDto(String username, String name) {
		this(username, name, "", "", "", "", "", "");
	}
	
	
	public HospitalDto(String username, String password, String name, String city, 
			String state, String strAddr, String description, String contact) {
		this(username,password,name,city,state,strAddr,description,contact, new ArrayList<RequestDto>());
	}
	
	
	public HospitalDto(String username, String password, String name, String city, 
			String state, String strAddr, String description, String contact,List<RequestDto> requests ) {
		this.username = username;
		this.password = password;
		this.name = name;
		this.city = city;
		this.state = state;
		this.strAddr = strAddr;
		this.description = description;
		this.contact = contact;
		this.requests = requests;
	}
	
	
	//Getter and Setters
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public List<RequestDto> getRequests() {
		return requests;
	}
	public void setRequests(List<RequestDto> requests) {
		this.requests = requests;
	}
}
