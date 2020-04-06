package com.poc.springboot.phone;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component("phonesResolver")
public class PhonesResolver implements DataFetcher<List<PhoneDO>>{

	@Override
	public List<PhoneDO> get(DataFetchingEnvironment environment) {
		
		final List<PhoneDO> phonesList = new ArrayList<>();
		
		final PhoneDO phone1 = new PhoneDO();
		phone1.setPhoneNumber("phone1");
		phone1.setValid(true);
		phone1.setPhoneNumberType("home");
		
		final PhoneDO phone2 = new PhoneDO();
		phone2.setPhoneNumber("phone2");
		phone2.setValid(true);
		phone2.setPhoneNumberType("mobile");
		
		phonesList.add(phone1);
		phonesList.add(phone2);
		
		return phonesList;
	}
}
