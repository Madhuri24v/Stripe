package com.Stripe.sample.rest;

import java.util.HashMap;
import java.util.Map;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Stripe.sample.commands.CardCommand;
import com.Stripe.sample.commands.StripeUserCommand;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.stripe.exception.StripeException;
import com.stripe.model.Customer;
import com.stripe.model.Token;
import com.stripe.param.CustomerRetrieveParams;

@RestController
public class UserCreation {

	Mapper mapper = new DozerBeanMapper();

	@RequestMapping(value = "/Add_user/", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> addStripeUser(@RequestBody StripeUserCommand command)
			throws StripeException {

		Map<String, Object> mMap = new HashMap<String, Object>();

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("email", command.getEmail());
		params.put("name", command.getName());

		Customer newCustomer = Customer.create(params);
		mMap.put("status", "success");
		mMap.put("id", newCustomer.getId());

		return mMap;

	}

	@RequestMapping(value = "/save_card_details/", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> saveCardDetails(@RequestBody CardCommand command) throws StripeException {
		Map<String, Object> mMap = new HashMap<String, Object>();

		
		CustomerRetrieveParams params = CustomerRetrieveParams.builder()
		        .addExpand("sources").build();
		Customer stripeCustomer = Customer.retrieve(command.getStripeUserId(), params, null);

		
		Map<String, Object> cardParams = new HashMap<String, Object>();

		cardParams.put("number", command.getCardNumber());
		cardParams.put("exp_month", command.getExpMonth());
		cardParams.put("exp_year", command.getExpYear());
		cardParams.put("cvc", command.getCvc());

		Map<String, Object> tokenParams = new HashMap<String, Object>();

		tokenParams.put("card", cardParams);

		Token token = Token.create(tokenParams);
		Map<String, Object> source = new HashMap<String, Object>();

		source.put("source", token.getId());

		stripeCustomer.getSources().create(source);

		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		mMap.put("status", "success");
		mMap.put("object", gson.toJson(stripeCustomer));
		return mMap;

	}

}
