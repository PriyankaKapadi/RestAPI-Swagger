package com.testingshashtra.requestspecbuild;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RequestSpecifications {
	static String baseUrl = "https://fakerestapi.azurewebsites.net/api/v1/Authors";
	static int validBookId=10;
	static int invalidBookId=500;
	static int validId=3;
	static int invalidId=-90;
	static int putId=1;
	static int deleteId=20;
	public static RequestSpecification getRequestSpecData() {
		RequestSpecBuilder rs = new RequestSpecBuilder();
		rs.setBaseUri(baseUrl);
		RequestSpecification requestspecification = rs.build();
		return requestspecification;
	}

	public static RequestSpecification getRequestSpecDataById() {
		RequestSpecBuilder rs = new RequestSpecBuilder();
		rs.setBaseUri(baseUrl);
		rs.setBasePath("/"+validId);
		RequestSpecification requestspecification = rs.build();
		return requestspecification;
	}

	public static RequestSpecification getRequestSpecDataByInvalidId() {
		RequestSpecBuilder rs = new RequestSpecBuilder();
		rs.setBaseUri(baseUrl);
		rs.setBasePath("/"+invalidId);
		RequestSpecification requestspecification = rs.build();
		return requestspecification;
	}

	public static RequestSpecification getRequestSpecDataByValidBookId() {
		RequestSpecBuilder rs = new RequestSpecBuilder();
		rs.setBaseUri(baseUrl);
		rs.setBasePath("/authors/books/"+validBookId);
		RequestSpecification requestspecification = rs.build();
		return requestspecification;
	}

	public static RequestSpecification getRequestSpecDataByInvalidBookId() {
		RequestSpecBuilder rs = new RequestSpecBuilder();
		rs.setBaseUri(baseUrl);
		rs.setBasePath("/authors/books/"+invalidBookId);
		RequestSpecification requestspecification = rs.build();
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
		rs.setBasePath("/"+putId);
		RequestSpecification requestspecification = rs.build();
		return requestspecification;
	}
	public static RequestSpecification deleteRequestSpecData() {
		RequestSpecBuilder rs=new RequestSpecBuilder();
		rs.setBaseUri(baseUrl);
		rs.setBasePath("/"+deleteId);
		RequestSpecification requestspecification=rs.build();
		return requestspecification;
	}
}
