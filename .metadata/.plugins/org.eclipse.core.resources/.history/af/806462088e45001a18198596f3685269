package mchacks9.wuhan.dto;

import java.sql.Time;
import java.util.List;



public class RequestDto {
	private long rid;
	private Time posttime;
	private String emerStatus;
	private String fulfillStatus;
	private HospitalDto hospital;
	private List<ItemEntryDto> items;
	// Constructors
	public RequestDto(long rid,  Time posttime) {
		this(rid, posttime, "", "");
	}
	
	
	public RequestDto(long rid,  Time posttime, String emerStatus, String fulfillStatus) {
		this(rid, posttime, emerStatus, fulfillStatus, null, null);
	}
	
	public RequestDto(long rid,  Time posttime, String emerStatus, String fulfillStatus, HospitalDto hospital,
			List<ItemEntryDto> items) {
		this.rid = rid;
		this.hospital = hospital;
		this.posttime = posttime;
		this.emerStatus = emerStatus;
		this.fulfillStatus = fulfillStatus;
		this.items = items;
	}


	//Getter and Setters
	public long getRid() {
		return rid;
	}
	public void setRid(long rid) {
		this.rid = rid;
	}
	public HospitalDto getHospital() {
		return hospital;
	}
	public void setHospital(HospitalDto hospital) {
		this.hospital = hospital;
	}
	public Time getPosttime() {
		return posttime;
	}
	public void setPosttime(Time posttime) {
		this.posttime = posttime;
	}
	public String getEmerStatus() {
		return emerStatus;
	}

	public void setEmerStatus(String emerStatus) {
		this.emerStatus = emerStatus;
	}


	public String getFulfillStatus() {
		return fulfillStatus;
	}


	public void setFulfillStatus(String fulfillStatus) {
		this.fulfillStatus = fulfillStatus;
	}
	
	public List<ItemEntryDto> getItems() {
		return items;
	}
	public void setItems(List<ItemEntryDto> items) {
		this.items = items;
	}
	
	
	
}
