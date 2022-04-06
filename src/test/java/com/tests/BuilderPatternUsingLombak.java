package com.tests;

import static io.restassured.RestAssured.given;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;
import com.pojo.Employee;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class BuilderPatternUsingLombak {
	
	@Test
	public void postJsonUsingBuilderTest() {
		
		Employee employee = Employee.builder()
		      .setId(generateRandomId())
		      .setEmail(generateRandomEmail())
		      .setFirst_name("Animesh")
		      .setLast_name("Shewale")
		      .build();
		
		System.out.println(employee);
		
		
		Response response = given().baseUri("http://localhost:3000")
		.contentType(ContentType.JSON)
		.log()
		.all()
		.body(employee)
		.post("/employees");
		
		System.out.println(generateRandomId());
		System.out.println(generateRandomEmail());
		Assert.assertEquals(response.getStatusCode(), 201);
		
	}

	private String generateRandomEmail() {
		String no = String.valueOf(new Faker().number().digits(2));
		String randomEmail = "jayesh"+no+"@gmail.com";
		return randomEmail ;
	}

	private String generateRandomId() {		
		return String.valueOf(new Faker().number().digits(2));
	}
	
	

}
