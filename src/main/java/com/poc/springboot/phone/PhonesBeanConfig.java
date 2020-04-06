package com.poc.springboot.phone;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;

@Configuration
public class PhonesBeanConfig {

	@Autowired
	private ResourceLoader resourceLoader;

	@Autowired
	@Qualifier("phonesResolver")
	private PhonesResolver phonesResolver;
	
	@Autowired
	@Qualifier("phoneResolver")
	private PhoneResolver phoneResolver;
	

	@Bean("phoneGraphQLSchema")
	public GraphQLSchema phoneGraphQLSchema(){
		final SchemaParser schemaParser = new SchemaParser();
		final SchemaGenerator schemaGenerator = new SchemaGenerator();

		Resource resource = null;
		try{ resource = resourceLoader.getResource("classpath:graphql/phone.graphqls");}
		catch(Exception exc){ System.out.println("ERROR: getting resource: " + exc.getMessage()); }

		File schemaFile = null;
		try{schemaFile = resource.getFile();}
		catch(Exception exc){ System.out.println("ERROR: getting file: " + exc.getMessage()); }

		TypeDefinitionRegistry registry = null;
		try{ registry = schemaParser.parse(schemaFile);}
		catch(Exception exc){ System.out.println("ERROR: getting registry: " + exc.getMessage()); }

		RuntimeWiring wiring = RuntimeWiring.newRuntimeWiring()
				.type("Query", builder -> builder
						.dataFetcher("phone",phoneResolver))
				.type("Query", builder -> builder
						.dataFetcher("phones",phonesResolver))
				.build();

		return schemaGenerator.makeExecutableSchema(registry,wiring);
	}

	
	/*@Bean("phonesGraphQLSchema")
	public GraphQLSchema phonesGraphQLSchema(){
		final SchemaParser schemaParser = new SchemaParser();
		final SchemaGenerator schemaGenerator = new SchemaGenerator();

		Resource resource = null;
		try{ resource = resourceLoader.getResource("classpath:graphql/phones.graphqls");}
		catch(Exception exc){ System.out.println("ERROR: getting resource: " + exc.getMessage()); }

		File schemaFile = null;
		try{schemaFile = resource.getFile();}
		catch(Exception exc){ System.out.println("ERROR: getting file: " + exc.getMessage()); }

		TypeDefinitionRegistry registry = null;
		try{ registry = schemaParser.parse(schemaFile);}
		catch(Exception exc){ System.out.println("ERROR: getting registry: " + exc.getMessage()); }

		RuntimeWiring wiring = RuntimeWiring.newRuntimeWiring()
				.type("FetchMultiplePhones", builder -> builder
						.dataFetcher("phones",phonesResolver)
						)
				.build();

		return schemaGenerator.makeExecutableSchema(registry,wiring);
	}*/

}
