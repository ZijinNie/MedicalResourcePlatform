package mchacks9.wuhan.model;

import java.sql.Time;
import java.util.Random;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import mchacks9.wuhan.satausEnum.EmergencyStatus;
import mchacks9.wuhan.satausEnum.FulfillStatus;


@Entity

public class Request {
	private long rid;
	private Hospital hospital;
	private Time posttime;
	private EmergencyStatus emerStatus;
	private FulfillStatus fulfillStatus;
	private Set<ItemEntry> items;
	
	public Request(Hospital hospital, Time posttime, EmergencyStatus emerStatus) {
		super();
		this.rid = new Random(124).nextLong();
		this.hospital = hospital;
		this.posttime = posttime;
		this.emerStatus = emerStatus;
		this.fulfillStatus = FulfillStatus.ONGOING;
	}
	
	@ManyToOne(optional = false)
	public Hospital getHospital() {
		return hospital;
	}
	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}
	public Time getPosttime() {
		return posttime;
	}
	public void setPosttime(Time posttime) {
		this.posttime = posttime;
	}
	public EmergencyStatus getEmerStatus() {
		return emerStatus;
	}
	public void setEmerStatus(EmergencyStatus emerStatus) {
		this.emerStatus = emerStatus;
	}
	public FulfillStatus getFulfillStatus() {
		return fulfillStatus;
	}
	public void setFulfillStatus(FulfillStatus fulfillStatus) {
		this.fulfillStatus = fulfillStatus;
	}

	@Id
	public long getRid() {
		return rid;
	}

	
	@OneToMany(cascade = { CascadeType.ALL })
	public Set<ItemEntry> getItems() {
		return items;
	}

	
	public void setItems(Set<ItemEntry> items) {
		this.items = items;
	}

}
