package swagger;

import org.hamcrest.Matchers;

import org.testng.annotations.Test;

import com.testingshashtra.requestspecbuild.RequestSpecificationsSwagger;

import static io.restassured.RestAssured.*;

public class ToVerifyBookfromSwagger {
	
	@Test
	public void verifyGetBookRequest() {
		given(RequestSpecificationsSwagger.getRequestSpecData())
		.when()
		.get()
		.then()
		.log()
		.all()
		.assertThat()
		.statusCode(200)
		.body("[0].id", Matchers.equalTo(1))
		.body("[0].title", Matchers.equalTo("Book 1"))
		.body("[0].pageCount", Matchers.equalTo(100))
		.log()
		.all();
	}
	
	@Test
	public void verifyGetBookDetailsByValidId() {
		given(RequestSpecificationsSwagger.getRequestSpecDataByID())
		.when()
		.get()
		.then()
		.log()
		.all()
		.assertThat()
		.statusCode(200)
		.body("id", Matchers.equalTo(2))
		.body("title", Matchers.equalTo("Book 2"))
		.body("pageCount", Matchers.equalTo(200))
		.log()
		.all();
	}
	
	@Test
	public void verifyGetBookDetailsByInvalidId() {
		given(RequestSpecificationsSwagger.getRequestSpecDataByInvalidID())
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
	public void verifyPostRequestOnBooksOfSwagger() {
		GoRestPostTestData01 dto=new GoRestPostTestData01();
		dto.setId(800);
		dto.setTitle("Book 800");
		dto.setDescription("My book");
		dto.setPageCount(10500);
		dto.setExcerpt("Jai Hind");
		dto.setPublishDate("2024-12-30T08:10:43.739Z");
		given(RequestSpecificationsSwagger.postRequestSpecData())
		.body(dto)
		.when()
		.post()
		.then()
		.log()
		.all()
		.assertThat()
		.statusCode(200)
		.body("id", Matchers.equalTo(800))
		.body("title", Matchers.equalToIgnoringCase("Book 800"))
		.body("description", Matchers.equalToIgnoringCase("My book"))
		.body("pageCount",Matchers.equalTo(10500))
		.body("excerpt",Matchers.equalToIgnoringCase("Jai Hind"))
		.body("publishDate",Matchers.equalToIgnoringCase("2024-12-30T08:10:43.739Z"))
		.log()
		.all();
	}
	
	@Test
	public void verifyPutRequestOnBooksOfSwagger() {
		GoRestPostTestData01 dto=new GoRestPostTestData01();
		dto.setId(900);
		dto.setTitle("Book 900");
		dto.setDescription("My book name is India");
		dto.setPageCount(1001);
		dto.setExcerpt("Jai Hind");
		dto.setPublishDate("2024-12-30T08:10:43.739Z");
		given(RequestSpecificationsSwagger.putRequestSpecData())
		.body(dto)
		.when()
		.put()
		.then()
		.log()
		.all()
		.assertThat()
		.statusCode(200)
		.body("id", Matchers.equalTo(900))
		.body("title", Matchers.equalToIgnoringCase("Book 900"))
		.body("description", Matchers.equalToIgnoringCase("My book name is India"))
		.body("pageCount",Matchers.equalTo(1001))
		.body("excerpt",Matchers.equalToIgnoringCase("Jai Hind"))
		.body("publishDate",Matchers.equalToIgnoringCase("2024-12-30T08:10:43.739Z"))
		.log()
		.all();
	}
	@Test
	public void verifyDeleteAuthorRequestByValidId() {
		given(RequestSpecificationsSwagger.deleteRequestSpecData())
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


