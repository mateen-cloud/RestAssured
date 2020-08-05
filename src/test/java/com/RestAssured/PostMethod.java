package com.RestAssured;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class PostMethod {


	@Test(priority=1)
	void create() {
		
		System.out.println("-----------------------------------------------------");
		// base uri
		RestAssured.baseURI="https://reqres.in/api/users";
		// request object
		RequestSpecification httpreq= RestAssured.given();
		
		// Request payload sending along with POST request
		
		JSONObject reqparams= new JSONObject();

		reqparams.put("name","mateen");
		reqparams.put("LastName", "Mohammed");
		reqparams.put("mail", "mateenmohd256@gmail.com");
		
		httpreq.header("Content-Type","application/json");
		httpreq.body(reqparams.toJSONString());
		// Response object
		Response response=httpreq.request(Method.POST,"/register");
		String rbody=response.getBody().asString();
		System.out.println("response body is :"+rbody);
		
		int statusCode=response.getStatusCode();
		System.out.println(" creat status code is :"+statusCode);
		Assert.assertEquals(201, statusCode);
		
		
	}

	@Test(priority=2)
	void registerSucessful() {
		
		System.out.println("-----------------------------------------------------");
		RestAssured.baseURI="https://reqres.in/api/register";
		
		RequestSpecification httpreq= RestAssured.given();
		
		
		JSONObject reqparams=new JSONObject();
		
		
		reqparams.put("email","zakeer235@gmail.com");	
		reqparams.put("passoword","pistol");	
		
	
		
		//response object
		
		httpreq.header("Content-Type","application/json");
		httpreq.body(reqparams.toJSONString());
		// Response object
		Response response=httpreq.request(Method.POST,"/register");
		String rbody=response.getBody().asString();
		System.out.println("response body is :"+rbody);
		
		int statusCode=response.getStatusCode();
		System.out.println("registerSucessful status code is :"+statusCode);
		Assert.assertEquals(201, statusCode);
		
	}
	
	@Test(priority=3)
	void registerUnSucessful() {
		System.out.println("-----------------------------------------------------");
		
		RestAssured.baseURI="https://reqres.in/api/register";
		
		RequestSpecification httpreq= RestAssured.given();
		
		
		JSONObject reqparams=new JSONObject();
	
		reqparams.put("passoword","pistol");	
		
		//response object
		
		httpreq.header("Content-Type","application/json");
		httpreq.body(reqparams.toJSONString());
		// Response object
		Response response=httpreq.request(Method.POST);
		String rbody=response.getBody().asString();
		System.out.println("response body is :"+rbody);
		
		int statusCode=response.getStatusCode();
		System.out.println("registerUnSucessful status code is :"+statusCode);
		Assert.assertEquals(400, statusCode);
		
	}
	
	@Test(priority=4)
	void loginSucessful() {
	System.out.println("-----------------------------------------------------");
		
		RestAssured.baseURI="https://reqres.in/api/login";
		
		RequestSpecification httpreq= RestAssured.given();
		
		
		JSONObject reqparams=new JSONObject();
	
		reqparams.put("email","eve.holt@reqres.in");	
		reqparams.put("passoword","cityslicka");		
		//response object
		
		httpreq.header("Content-Type","application/json");
		httpreq.body(reqparams.toJSONString());
		// Response object
		Response response=httpreq.request(Method.POST,"/login");
		String rbody=response.getBody().asString();
		System.out.println("response body is :"+rbody);
		
		int statusCode=response.getStatusCode();
		System.out.println("loginSucessful status code is :"+statusCode);
		Assert.assertEquals(201, statusCode);
		
	}
	
	@Test(priority=5)
	void loginUnsucessfull() {
		
System.out.println("-----------------------------------------------------");
		
		RestAssured.baseURI="https://reqres.in/api/login";
		
		RequestSpecification httpreq= RestAssured.given();
		
		
		JSONObject reqparams=new JSONObject();
	
		reqparams.put("email","eve.holt@reqres.in");	
		
		//response object
		
		httpreq.header("Content-Type","application/json");
		httpreq.body(reqparams.toJSONString());
		// Response object
		Response response=httpreq.request(Method.POST);
		String rbody=response.getBody().asString();
		System.out.println("response body is :"+rbody);
		
		int statusCode=response.getStatusCode();
		System.out.println("loginUnsucessfull status code is :"+statusCode);
		Assert.assertEquals(400, statusCode);
		
		
		
	}
	
	
}
