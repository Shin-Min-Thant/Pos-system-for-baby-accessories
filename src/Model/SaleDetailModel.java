package Model;


public class SaleDetailModel {
	private String sale_id;
	private String item_id;
	private int sale_price;
	private int sale_qty;
	private String item_name;
	
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public int getSale_price() {
		return sale_price;
	}
	public void setSale_price(int sale_price) {
		this.sale_price = sale_price;
	}
	public int getSale_qty() {
		return sale_qty;
	}
	public void setSale_qty(int sale_qty) {
		this.sale_qty = sale_qty;
	}
	public String getSale_id() {
		return sale_id;
	}
	public void setSale_id(String sale_id) {
		this.sale_id = sale_id;
	}
	public String getItem_id() {
		return item_id;
	}
	public void setItem_id(String item_id) {
		this.item_id = item_id;
	}
	

}
