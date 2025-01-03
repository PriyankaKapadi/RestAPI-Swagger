package swagger;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RequestSpecificationBuild {
	static String SwaggerBaseUri = "https://fakerestapi.azurewebsites.net/api/v1/Activities";

	public static RequestSpecification Reqspec() {
		RequestSpecBuilder builder = new RequestSpecBuilder();
		builder.setContentType(ContentType.JSON);
		builder.setBaseUri(SwaggerBaseUri);
		RequestSpecification requestpecification = builder.build();
		return requestpecification;

	}

}
