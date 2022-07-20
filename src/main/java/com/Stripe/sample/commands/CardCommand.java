package com.Stripe.sample.commands;

public class CardCommand {

	String stripeUserId;
	
	String cardNumber;
	
	String expMonth;
	
	String expYear;
	
	String cvc;

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getExpMonth() {
		return expMonth;
	}

	public void setExpMonth(String expMonth) {
		this.expMonth = expMonth;
	}

	public String getExpYear() {
		return expYear;
	}

	public void setExpYear(String expYear) {
		this.expYear = expYear;
	}

	public String getCvc() {
		return cvc;
	}

	public void setCvc(String cvc) {
		this.cvc = cvc;
	}
	public String getStripeUserId() {
		return stripeUserId;
	}

	public void setStripeUserId(String stripeUserId) {
		this.stripeUserId = stripeUserId;
	}

	@Override
	public String toString() {
		return "CardCommand [stripeUserId=" + stripeUserId + ", cardNumber=" + cardNumber + ", expMonth=" + expMonth
				+ ", expYear=" + expYear + ", cvc=" + cvc + "]";
	}
	
	
}
