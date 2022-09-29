package in.co.gorest.userinfo;

import in.co.gorest.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class DeleteTest extends TestBase {

    @Test
    public void delete (){
        Response response = given()
                .pathParam("id", "4180")
                .when()
                .delete("/{id}");
        response.then();//.statusCode(204);
        response.prettyPrint();
    }
}
