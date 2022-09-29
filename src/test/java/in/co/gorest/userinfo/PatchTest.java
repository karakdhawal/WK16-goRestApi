package in.co.gorest.userinfo;

import in.co.gorest.model.UserPojo;
import in.co.gorest.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class PatchTest extends TestBase {

    @Test
    public void userPatchTest (){
    UserPojo userPojo = new UserPojo();
    userPojo.setName("lord31");

        Response response = given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer 65cbc4c43040ae97eb012d87fb6bb928809feb842bfeba5ea49b2969ea92ede6")
                .pathParam("id", "4180")
                .body(userPojo)
                .when()
                .patch("/{id}");
        response.then();//.statusCode(200);
        response.prettyPrint();

    }

}
