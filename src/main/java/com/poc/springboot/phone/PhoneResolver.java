package com.poc.springboot.phone;

import org.springframework.stereotype.Component;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component("phoneResolver")
public class PhoneResolver implements DataFetcher<PhoneDO>{

	@Override
	public PhoneDO get(DataFetchingEnvironment environment) {
	
		final PhoneDO phone = new PhoneDO();
		phone.setPhoneNumber("9891");
		phone.setValid(true);
		phone.setPhoneNumberType("home");
		
		return phone;
	}

}
