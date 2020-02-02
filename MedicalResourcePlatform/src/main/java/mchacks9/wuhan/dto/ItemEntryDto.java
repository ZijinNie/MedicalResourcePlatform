package mchacks9.wuhan.dto;

;

public class ItemEntryDto {
	
//	private long ieid;
	private int quantity;
	private ItemDto item;
	
	public ItemEntryDto() {
		
	}
	// Constructors
	public ItemEntryDto( int quantity) {
		this(quantity,null);
	}
	
	public ItemEntryDto(int quantity, ItemDto item) {
//		this.ieid = ieid;
		this.item = item;
		this.quantity = quantity;
	}
	
//	//Getter and Setters
//	public long getIeid() {
//		return ieid;
//	}
//
//	public void setIeid(long ieid) {
//		this.ieid = ieid;
//	}
	public ItemDto getItem() {
		return item;
	}
	public void setItem(ItemDto item) {
		this.item = item;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	
}
