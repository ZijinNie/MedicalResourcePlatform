package mchacks9.wuhan.model;

import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ItemEntry {
	private long ieid;
	private Item item;
	private int quantity;
	private Request request;
	
	public ItemEntry(Item item, int quantity, Request request) {
		super();
		this.ieid = new Random().nextLong();
		this.item = item;
		this.request = request;
		this.quantity = quantity;
	}
	
	public ItemEntry() {
		super();
		this.ieid = new Random().nextLong();
	}
	
	
	@ManyToOne(optional = false)
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	@Id
	public long getIeid() {
		return ieid;
	}

	public void setIeid(long id) {};
	
	@ManyToOne(optional = false)
	public Request getRequest() {
		return request;
	}

	public void setRequest(Request request) {
		this.request = request;
	}

	
}
