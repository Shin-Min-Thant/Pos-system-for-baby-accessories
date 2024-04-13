package Model;

import javax.swing.ImageIcon;

public class DeliverModel {
	private String deliver_id;
	private String name;
	private String address;
	private String phone;
	private String email;
	private int deliver_capacity;
	private ImageIcon img;
	public ImageIcon getImg() {
		return img;
	}
	public void setImg(ImageIcon img) {
		this.img = img;
	}
	public int getDeliver_capacity() {
		return deliver_capacity;
	}
	public void setDeliver_capacity(int deliver_capacity) {
		this.deliver_capacity = deliver_capacity;
	}
	public String getDeliver_id() {
		return deliver_id;
	}
	public void setDeliver_id(String deliver_id) {
		this.deliver_id = deliver_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
