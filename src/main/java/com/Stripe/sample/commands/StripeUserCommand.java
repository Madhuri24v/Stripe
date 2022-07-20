package com.Stripe.sample.commands;

public class StripeUserCommand {

	
	String email;
	
	String address;
	
	String discount;
	
	String currency;
	
	String name;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "StripeUserCommand [email=" + email + ", address=" + address + ", discount=" + discount + ", currency="
				+ currency + ", name=" + name + "]";
	}
	
	
}
