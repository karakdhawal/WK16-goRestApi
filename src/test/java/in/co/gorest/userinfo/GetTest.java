package in.co.gorest.userinfo;

import in.co.gorest.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetTest extends TestBase {

@Test
public void getAllUsers (){
    Response response = given()
            .when()
            .get("");
    response.then().statusCode(200);
    response.prettyPrint();
}
@Test
    public void getSingleUser (){
    Response response = given()
            .pathParam("id", "2267")
            .when()
            .get("/{id}");
    response.then().statusCode(200);
    response.prettyPrint();
}
@Test
    public void chechdeletedID (){
    Response response = given()
            .pathParam("id", "4180")
            .when()
            .get("/{id}");
    response.then().statusCode(404);
    response.prettyPrint();
}

}
