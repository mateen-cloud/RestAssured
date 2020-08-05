package com.RestAssured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class GetMethode {

	@Test(priority=1)
	void getListUsers() {
		
		System.out.println("--------------------------------------------");
		
	RestAssured.baseURI="https://reqres.in/api";
		
	RequestSpecification httpreq=RestAssured.given();
	
Response response	=httpreq.request(Method.GET,"/users?page=2");


// response body
String responseBody=response.getBody().asString();	
System.out.println("response body is :"+responseBody);


responseBody.contains("last_name\":\"Lawson\"");

// status code
int Statuscode=response.getStatusCode();
System.out.println("status code is :"+Statuscode);
Assert.assertEquals(200, Statuscode);
 
// statuse line
String StatusLine=response.getStatusLine();
System.out.println("status line is : "+StatusLine);
Assert.assertEquals("HTTP/1.1 200 OK", StatusLine);


// session id
System.out.println("session_id");
String session_id=response.getSessionId();
System.out.println(session_id);

// response as array

System.out.println("response in array form "+response.asByteArray());

System.out.println("Response time is : "+response.getTime());

System.out.println("cookies :"+response.getCookies());

System.out.println("jason path :"+response.jsonPath());

	// headers
		
System.out.println("Header part");

	Headers allHeaders=response.getHeaders();

		for(Header h:allHeaders) {
			
			System.out.println(h);
		}
	
		String content=response.getHeader("Content-Type");
		System.out.println(content);
		Assert.assertEquals("application/json; charset=utf-8", content);	
	
	}
	
	
@Test(priority=2)
void getSingleUser() {
	
	System.out.println("-------------------------------------------------");
	
	RestAssured.baseURI="https://reqres.in/api/users";
	
	RequestSpecification httpreq=RestAssured.given();
	
Response response=httpreq.request(Method.GET,"/2");

String responseBody=response.getBody().asString();
	
System.out.println("response body single user is :"+responseBody);
	
int statusCode=response.getStatusCode();

System.out.println("status code is :"+statusCode);
Assert.assertEquals(200, statusCode);

	
}

@Test(priority=3)
void SingleUserNotFound() {
	
	System.out.println("-----------------------------------------");
	
	RestAssured.baseURI="https://reqres.in/api/users";
	
	RequestSpecification httpreq=RestAssured.given();
	
Response respone=httpreq.request(Method.GET,"/23");
	
String rbody=respone.getBody().asString();

System.out.println("response body is :"+rbody);

int statusCode= respone.getStatusCode();

System.out.println("response code is :"+statusCode);
	
Assert.assertEquals(404, statusCode);

}

@Test(priority=4)
void ListResource() {
	
	System.out.println("-----------------------------------------");
	// base URI
	RestAssured.baseURI="https://reqres.in/api";
	
	// Request object
	RequestSpecification httpreq=RestAssured.given();
	
	// Response object
	
	Response response= httpreq.request(Method.GET,"/unknown");
	
	String rbody=response.getBody().asString();
	
	System.out.println("response body is :"+rbody);
	
int statusCode	=response.getStatusCode();
System.out.println("status code is "+statusCode);
Assert.assertEquals(200, statusCode);
	
}

@Test(priority=5)
void SingleResource() {
	
	
	System.out.println("-----------------------------------------");
	// base URI
	RestAssured.baseURI="https://reqres.in/api/unknown";
	
	// Request object
	RequestSpecification httpreq=RestAssured.given();
	
	// Response object
	
	Response response= httpreq.request(Method.GET,"/2");
	
	String rbody=response.getBody().asString();
	
	System.out.println("response body is :"+rbody);
	
int statusCode	=response.getStatusCode();
System.out.println("status code is "+statusCode);
Assert.assertEquals(200, statusCode);
}

@Test(priority=6)
void SingleResourceNotFound() {
	
	
	System.out.println("-----------------------------------------");
	// base URI
	RestAssured.baseURI="https://reqres.in/api/unknown";
	
	// Request object
	RequestSpecification httpreq=RestAssured.given();
	
	// Response object
	
	Response response= httpreq.request(Method.GET,"/23");
	
	String rbody=response.getBody().asString();
	
	System.out.println("response body is :"+rbody);
	
int statusCode	=response.getStatusCode();
System.out.println("status code is "+statusCode);
Assert.assertEquals(404, statusCode);
	
	
}

@Test(priority=7)
void delayResponse(){
	
	
	System.out.println("-----------------------------------------");
	// base URI
	RestAssured.baseURI="https://reqres.in/api";
	
	// Request object
	RequestSpecification httpreq=RestAssured.given();
	
	// Response object
	
	Response response= httpreq.request(Method.GET,"/users?delay=2");
	
	String rbody=response.getBody().asString();
	
	System.out.println("response body is :"+rbody);
		
int statusCode	=response.getStatusCode();
System.out.println("status code is "+statusCode);
Assert.assertEquals(200, statusCode);
	
}

	}
	
	

