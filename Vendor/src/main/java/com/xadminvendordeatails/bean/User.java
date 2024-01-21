package com.xadminvendordeatails.bean;

public class User {
	
	
	
		protected String VendorName;
		protected long BankAccountNo;
		protected String BankName;
		protected String Address_line1;
		protected String Address_line2;
		protected String City;
		protected String Country;
		protected long zip;
		
		
		
		public User(String vendorName, long bankAccountNo, String bankName, String address_line1, String address_line2,
				String city, String country, long zip) {
		
			VendorName = vendorName;
			BankAccountNo = bankAccountNo;
			BankName = bankName;
			Address_line1 = address_line1;
			Address_line2 = address_line2;
			City = city;
			Country = country;
			this.zip = zip;
		}



		public String getVendorName() {
			return VendorName;
		}



		public void setVendorName(String vendorName) {
			VendorName = vendorName;
		}



		public long getBankAccountNo() {
			return BankAccountNo;
		}



		public void setBankAccountNo(long bankAccountNo) {
			BankAccountNo = bankAccountNo;
		}



		public String getBankName() {
			return BankName;
		}



		public void setBankName(String bankName) {
			BankName = bankName;
		}



		public String getAddress_line1() {
			return Address_line1;
		}



		public void setAddress_line1(String address_line1) {
			Address_line1 = address_line1;
		}



		public String getAddress_line2() {
			return Address_line2;
		}



		public void setAddress_line2(String address_line2) {
			Address_line2 = address_line2;
		}



		public String getCity() {
			return City;
		}



		public void setCity(String city) {
			City = city;
		}



		public String getCountry() {
			return Country;
		}



		public void setCountry(String country) {
			Country = country;
		}



		public long getZip() {
			return zip;
		}



		public void setZip(long zip) {
			this.zip = zip;
		}
		
		
		
		
		
		
		

}
