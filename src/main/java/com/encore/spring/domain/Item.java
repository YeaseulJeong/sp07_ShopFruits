package com.encore.spring.domain;

/*
 * VO, Domain, Pojo
 */
public class Item {
	private Integer itemId; // item_id
	private String itemName;// item_name
	private Integer price;
	private String description;
	private String url; // picture_url
	private Integer count;
	
	public Integer getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescripton(String descripton) {
		this.description = descripton;
	}
	public String getUrl() {
		return url;
	}
	public void setPictureUrl(String url) {
		this.url = url;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemName=" + itemName + ", price=" + price + ", description=" + description
				+ ", url=" + url + ", count=" + count + "]";
	}
	
	
	

}
