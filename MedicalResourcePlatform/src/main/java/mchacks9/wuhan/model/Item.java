package mchacks9.wuhan.model;

import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity

public class Item {
	private long iid;
	private String name;
	private String description;
	
	public Item(String name, String description) {
		super();
		this.iid = new Random(658).nextLong();
		this.name = name;
		this.description = description;
	}
	public Item() {
		this.iid = new Random(658).nextLong();

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
	@Id
	public long getIid() {
		return iid;
	}
	
	public void setIid(long id) {
		this.iid=id;
	}
}
