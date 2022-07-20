package com.Stripe.sample;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.http.converter.json.GsonBuilderUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Customer;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class StripeSampleProjectApplication {

	public static void main(String[] args) throws StripeException {
		SpringApplication.run(StripeSampleProjectApplication.class, args);

		Stripe.apiKey = "sk_test_51LNAKkSHIbQ2ry49IhzZtC2SOQMW5xMBRRWiW47nkd67PyfrjuEWDPhjvwme7zZlD3LiH5uch3SGguvFi9Wk2n1c00daS6QcnL";


	}
	 

}
