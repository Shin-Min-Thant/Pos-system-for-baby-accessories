package Model;

public class DeliveryDetailModel {
	private String delivery_id;
	private String order_id;
	private int delivery_price;
	private int delivery_qty;
	private String item_name;
	private String delive_fees;
	private String address;
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDelive_fees() {
		return delive_fees;
	}
	public void setDelive_fees(String delive_fees) {
		this.delive_fees = delive_fees;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public String getDelivery_id() {
		return delivery_id;
	}
	public void setDelivery_id(String delivery_id) {
		this.delivery_id = delivery_id;
	}
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public int getDelivery_price() {
		return delivery_price;
	}
	public void setDelivery_price(int delivery_price) {
		this.delivery_price = delivery_price;
	}
	public int getDelivery_qty() {
		return delivery_qty;
	}
	public void setDelivery_qty(int delivery_qty) {
		this.delivery_qty = delivery_qty;
	}
	
}
