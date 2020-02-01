package mchacks9.wuhan.dto;

;

public class ItemEntryDto {
	
	private long ieid;
	private int quantity;
	private ItemDto item;
	private RequestDto request;
	
	// Constructors
	public ItemEntryDto(long ieid, int quantity) {
		this(ieid,quantity,null,null);
	}
	
	public ItemEntryDto(long ieid, int quantity, ItemDto item, RequestDto request) {
		this.ieid = ieid;
		this.item = item;
		this.quantity = quantity;
		this.request = request;
	}
	
	//Getter and Setters
	public long getIeid() {
		return ieid;
	}

	public void setIeid(long ieid) {
		this.ieid = ieid;
	}
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
	public RequestDto getRequest() {
		return request;
	}
	public void setRequest(RequestDto request) {
		this.request = request;
	}
	
	
}
