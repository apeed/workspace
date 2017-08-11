package com.dao;

public class BuyList {
		public String warename;
		public float price;
		public int number;
		public String photo;
		public String id;
		public BuyList() {
			// TODO Auto-generated constructor stub
		}
		public BuyList(String warename, float price, int number, String photo, String id) {
			super();
			this.warename = warename;
			this.price = price;
			this.number = number;
			this.photo = photo;
			this.id = id;
		}
		public String getWarename() {
			return warename;
		}
		public void setWarename(String warename) {
			this.warename = warename;
		}
		public float getPrice() {
			return price;
		}
		public void setPrice(float price) {
			this.price = price;
		}
		public int getNumber() {
			return number;
		}
		public void setNumber(int number) {
			this.number = number;
		}
		public String getPhoto() {
			return photo;
		}
		public void setPhoto(String photo) {
			this.photo = photo;
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		@Override
		public String toString() {
			return "BuyList [warename=" + warename + ", price=" + price + ", number=" + number + ", photo=" + photo
					+ ", id=" + id + "]";
		}
		
}
