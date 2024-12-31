package swagger;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.testingshashtra.requestspecbuild.RequestSpecifications;

import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class AuthorsFromSwagger {
	static String invalidFirstname="1111";
	static String invalidLastName="Henry";
	
	@Test
	public void verifyGetAuthorRequest() {
		given(RequestSpecifications.getRequestSpecData())
		.when()
		.get()
		.then()
		.log()
		.all()
		.assertThat()
		.statusCode(200)
		.body("[0].id", Matchers.equalTo(1))
		.body("[0].idBook", Matchers.equalTo(1))
		.body("[0].firstName", Matchers.equalToIgnoringCase("First Name 1"))
		.body("[0].lastName",Matchers.equalToIgnoringCase("Last Name 1"))
		.log()
		.all();
	}
	
	@Test
	public void verifyGetAuthorDetailsByValidId() {
		given(RequestSpecifications.getRequestSpecDataById())
		.when()
		.get()
		.then()
		.log()
		.all()
		.assertThat()
		.statusCode(200)
		.body("id", Matchers.equalTo(3))
		.body("idBook", Matchers.equalTo(1))
		.body("firstName", Matchers.equalToIgnoringCase("First Name 3"))
		.body("lastName",Matchers.equalToIgnoringCase("Last Name 3"))
		.log()
		.all();
	}
	
	@Test
	public void verifyGetInvalidAuthorDetailsByValidId() {
		given(RequestSpecifications.getRequestSpecDataByInvalidId())
		.when()
		.get()
		.then()
		.log()
		.all()
		.assertThat()
		.statusCode(404)
		.log()
		.all();
	}
	
	@Test
	public void verifyGetValidAuthorsBookId() {
		given(RequestSpecifications.getRequestSpecDataByValidBookId())
		.when()
		.get()
		.then()
		.log()
		.all()
		.assertThat()
		.statusCode(200)
		.body("[0].id", Matchers.equalTo(29))
		.body("[0].idBook", Matchers.equalTo(10))
		.body("[0].firstName", Matchers.equalToIgnoringCase("First Name 29"))
		.body("[0].lastName",Matchers.equalToIgnoringCase("Last Name 29"))
		.log()
		.all();
	}
	@Test
	public void verifyGetInvalidAuthorsBookId() {
		given(RequestSpecifications.getRequestSpecDataByInvalidBookId())
		.when()
		.get()
		.then()
		.log()
		.all()
		.assertThat()
		.statusCode(200)
		.log()
		.all();
	}
	@Test
	public void verifyPostRequestOnAuthorOfSwagger() {
		GoRestPostTestData dto=new GoRestPostTestData();
		dto.setId(700);
		dto.setBookid(11);
		dto.setFirstname("My book");
		dto.setLastname("Henry");
		given(RequestSpecifications.postRequestSpecData())
		.body(dto)
		.when()
		.post()
		.then()
		.log()
		.all()
		.assertThat()
		.statusCode(200)
		.body("id", Matchers.equalTo(700))
		//.body("idBook", Matchers.equalTo(0))
		.body("firstName", Matchers.equalToIgnoringCase("My book"))
		.body("lastName",Matchers.equalToIgnoringCase("Henry"))
		.log()
		.all();
	}
	@Test
	public void verifyPostRequestWhenUserEntersZeroAsIdOnAuthorOfSwagger() {
		GoRestPostTestData dto=new GoRestPostTestData();
		dto.setId(0);
		dto.setBookid(11);
		dto.setFirstname("My book");
		dto.setLastname("Henry");
		given(RequestSpecifications.postRequestSpecData())
		.body(dto)
		.when()
		.post()
		.then()
		.log()
		.all()
		.assertThat()
		.statusCode(200)
		.log()
		.all();
	}
	@Test
	public void verifyPostRequestWhenUserEntersFirstNameAsNumbersOnlyOnAuthorOfSwagger() {
		GoRestPostTestData dto=new GoRestPostTestData();
		dto.setId(700);
		dto.setBookid(11);
		dto.setFirstname(invalidFirstname);
		dto.setLastname(invalidLastName);
		given(RequestSpecifications.postRequestSpecData())
		.body(dto)
		.when()
		.post()
		.then()
		.log()
		.all()
		.assertThat()
		.statusCode(200)
		.log()
		.all();
	}

	@Test
	public void verifyPutRequestOnAuthorsByValidId() {
		GoRestPostTestData dto=new GoRestPostTestData();
		dto.setId(1);
		dto.setBookid(16);
		dto.setFirstname("Akash");
		dto.setLastname("Singh");
		given(RequestSpecifications.putRequestSpecData())
		.body(dto)
		.when()
		.put()
		.then()
		.log()
		.all()
		.assertThat()
		.statusCode(200)
		.body("id", Matchers.equalTo(1))
		.body("idBook", Matchers.equalTo(0))
		.body("firstName", Matchers.equalToIgnoringCase("Akash"))
		.body("lastName",Matchers.equalToIgnoringCase("Singh"))
		.log()
		.all();
	}
	@Test
	public void verifyDeleteAuthorRequestByValidId() {
		given(RequestSpecifications.deleteRequestSpecData())
		.when()
		.delete()
		.then()
		.log()
		.all()
		.assertThat()
		.statusCode(200)
		.log()
		.all();
	}
	
}
