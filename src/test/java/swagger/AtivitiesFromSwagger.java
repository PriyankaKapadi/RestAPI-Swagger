package swagger;


import static io.restassured.RestAssured.*;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import com.testingshashtra.requestspecbuild.SwaggerDTOdemo;
import io.restassured.http.ContentType;





public class AtivitiesFromSwagger {

	@Test
	public void toVerifyGetActivities() {
		given()
		.when()
		.get("https://fakerestapi.azurewebsites.net/api/v1/Activities")
		.then()
		.assertThat()
		.log()
		.all()
		.assertThat()
		.statusCode(200)
		.body( "[0].id",Matchers.equalTo(1))
		.body("[0].title",Matchers.equalTo("Activity 1"))
		.log()
		.all();
		
		
	}
	
	@Test
	public void toVerifyPostActivities() {
		SwaggerDTOdemo dto= new SwaggerDTOdemo();
		dto.setId("400");
		dto.setTitle("Java");
		given(RequestSpecificationBuild.Reqspec())
		.body(dto)
		.contentType(ContentType.JSON)
		.log()
		.all()
		.when()
		.post()
		.then()
		.assertThat()
		.statusCode(200)
		.body( "id",Matchers.equalTo(400))
		.body("title",Matchers.equalToIgnoringCase("Java"))
		.log()
		.all();
	}
	
	@Test
	
	public void toVerifyGetActivitiesWithIdAsParameter() {
		given(RequestSpecificationBuild.Reqspec())
		.pathParam("ID", "3")
		.when()
		.get("{ID}")
		.then()
		.assertThat()
		.statusCode(200)
		.log()
		.all();
		
	}
	
	@Test
	public void toVerifyGetActivitiesWithParameterForInvalidUserID() {
		given(RequestSpecificationBuild.Reqspec())
		.pathParam("ID", "0")
		.when()
		.get("{ID}")
		.then()
		.assertThat()
		.statusCode(404)
		.log()
		.all();
		
	}
	
	@Test
	public void toVerifyGetActivitiesWithParameterForNegativeID() {
		given(RequestSpecificationBuild.Reqspec())
		.pathParam("ID", "-9")
		.when()
		.get("{ID}")
		.then()
		.assertThat()
		.statusCode(404)
		.log()
		.all();
		
	}
	
	@Test
	public void toVerifyPutActivitiesWithIdAsParameter() {
		SwaggerDTOdemo dto= new SwaggerDTOdemo();
		dto.setId("99");
		dto.setTitle("Rest Api");
		given(RequestSpecificationBuild.Reqspec())
		.body(dto)
		.pathParam("ID", "99")
		.log()
		.all()
		.when()
		.put("{ID}")
		.then()
		.assertThat()
		.statusCode(200)
		.body("id", Matchers.equalTo(99))
		.body("title", Matchers.equalToIgnoringCase("Rest Api"))
		.log()
		.all();
	}
	
	@Test
	public void toVerifyPutActivitiesWithIdAsZeroAsParameter() {
		SwaggerDTOdemo dto= new SwaggerDTOdemo();
		dto.setId("0");
		dto.setTitle("Rest Api");
		given(RequestSpecificationBuild.Reqspec())
		.body(dto)
		.pathParam("ID", "0")
		.log()
		.all()
		.when()
		.put("{ID}")
		.then()
		.assertThat()
		.statusCode(200)
		.body("id", Matchers.equalTo(0))
		.body("title", Matchers.equalToIgnoringCase("Rest Api"))
		.log()
		.all();
	}
	
	
	
	@Test
	public void toVerifyDeleteActivitiesByValidId() {
		SwaggerDTOdemo dto= new SwaggerDTOdemo();
		given(RequestSpecificationBuild.Reqspec())
		.body(dto)
		.pathParam("ID", "99")
		.log()
		.all()
		.when()
		.delete("{ID}")
		.then()
		.assertThat()
		.statusCode(200)
		.log()
		.all();
	}
	
}
