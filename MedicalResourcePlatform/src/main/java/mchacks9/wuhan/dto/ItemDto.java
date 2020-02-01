package mchacks9.wuhan.dto;

public class ItemDto {
	private long iid;
	private String name;
	private String description;
	// Constructors
	public ItemDto(long iid) {
		this(iid,"");
	}
	
	public ItemDto(long iid, String name) {
		this(iid,name,"");
	}
	
	public ItemDto(long iid, String name, String description) {
		this.iid = iid;
		this.name = name;
		this.description = description;
	}
	
	
	//Getter and Setters
	public long getIid() {
		return iid;
	}

	public void setIid(long iid) {
		this.iid = iid;
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
}
