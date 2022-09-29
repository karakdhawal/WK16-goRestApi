package in.co.gorest.userinfo;

import in.co.gorest.model.UserPojo;
import in.co.gorest.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class PostTest extends TestBase {

    @Test
    public void createProduct (){
        UserPojo userPojo = new UserPojo();
        userPojo.setName("lord11");
        userPojo.setEmail("lord11uk@gmail.com");
        userPojo.setGender("male");
        userPojo.setStatus("active");

        Response response = given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer 65cbc4c43040ae97eb012d87fb6bb928809feb842bfeba5ea49b2969ea92ede6")
                .body(userPojo)
                .when()
                .post();
        response.then();//.statusCode(201);
        response.prettyPrint();
    }

}
