package com.testingshashtra.requestspecbuild;

import io.restassured.builder.RequestSpecBuilder;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;


public class RequestSpecificationsSwagger {
	static String baseUrl="https://fakerestapi.azurewebsites.net/api/v1/Books";
	
	public static RequestSpecification getRequestSpecData() {
		RequestSpecBuilder rs=new RequestSpecBuilder();
		rs.setBaseUri(baseUrl);
		RequestSpecification requestspecification=rs.build();
		return requestspecification;
	}
	
	public static RequestSpecification getRequestSpecDataByID() {
		RequestSpecBuilder rs=new RequestSpecBuilder();
		rs.setBaseUri(baseUrl);
		rs.setBasePath("/2");
		RequestSpecification requestspecification=rs.build();
		return requestspecification;
	}
	
	public static RequestSpecification getRequestSpecDataByInvalidID() {
		RequestSpecBuilder rs=new RequestSpecBuilder();
		rs.setBaseUri(baseUrl);
		rs.setBasePath("/500");
		RequestSpecification requestspecification=rs.build();
		return requestspecification;
	}
	
	public static RequestSpecification postRequestSpecData() {
		RequestSpecBuilder rs = new RequestSpecBuilder();
		rs.setContentType(ContentType.JSON);
		rs.setBaseUri(baseUrl);
		RequestSpecification requestspecification = rs.build();
		return requestspecification;
	}
	
	public static RequestSpecification putRequestSpecData() {
		RequestSpecBuilder rs = new RequestSpecBuilder();
		rs.setContentType(ContentType.JSON);
		rs.setBaseUri(baseUrl);
		rs.setBasePath("/1");
		RequestSpecification requestspecification = rs.build();
		return requestspecification;
	}
	
	public static RequestSpecification deleteRequestSpecData() {
		RequestSpecBuilder rs=new RequestSpecBuilder();
		rs.setBaseUri(baseUrl);
		rs.setBasePath("/10");
		RequestSpecification requestspecification=rs.build();
		return requestspecification;
	}
}
