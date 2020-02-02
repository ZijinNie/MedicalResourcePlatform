package mchacks9.wuhan.controller;

import java.sql.Time;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import mchacks9.wuhan.dto.ItemEntryDto;

public class RequestForm {
	private String city;
	private String contact;
	private String hospital;
	private String address;
	private String state;
	private String time;
	private List<ItemEntryDto> itemEntry;

	public RequestForm(){
		
	}
	public RequestForm(String city, String contact, String hospital, String address, String state, String time,
			List<ItemEntryDto> itemEntry) {
		super();
		this.city = city;
		this.contact = contact;
		this.hospital = hospital;
		this.address = address;
		this.state = state;
		this.time = time;
		this.itemEntry = itemEntry;
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getHospital() {
		return hospital;
	}
	public void setHospital(String hospital) {
		this.hospital = hospital;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public List<ItemEntryDto> getItemEntry() {
		return itemEntry;
	}
	public void setItemEntry(List<ItemEntryDto> itemEntry) {
		this.itemEntry = itemEntry;
	}
}
