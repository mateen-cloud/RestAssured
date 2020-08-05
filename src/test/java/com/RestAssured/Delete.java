package com.RestAssured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class Delete {
	@Test
	void delete() {
		
		
		System.out.println("-------------------------------------------------");
		
		RestAssured.baseURI="https://reqres.in/api/users";
		
		RequestSpecification httpreq=RestAssured.given();
		
	Response response=httpreq.request(Method.DELETE,"/2");

	String responseBody=response.getBody().asString();
		
	System.out.println("response body single user is :"+responseBody);
		
	int statusCode=response.getStatusCode();

	System.out.println("delete mehthod status code is :"+statusCode);
	Assert.assertEquals(204, statusCode);
	}
	

}
