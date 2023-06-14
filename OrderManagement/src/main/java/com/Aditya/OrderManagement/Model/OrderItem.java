package com.Aditya.OrderManagement.Model;

public class OrderItem {
    private String itemId;
    private String itemName;
    private int quantity;
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public OrderItem(String itemId, String itemName, int quantity) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.quantity = quantity;
	}
	public OrderItem() {
		super();
		// TODO Auto-generated constructor stub
	}

    
}
