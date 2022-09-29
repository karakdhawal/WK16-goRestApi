package in.co.gorest.userinfo;

import in.co.gorest.model.UserPojo;
import in.co.gorest.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class CRUDTest extends TestBase {

    int id;

    @Test //list
    public void test001 (){
        Response response = given()
                .when()
                .get("");
        response.then().statusCode(200);
        response.prettyPrint();

    }
    @Test // create User
    public void test002 (){
        UserPojo userPojo = new UserPojo();
        userPojo.setName("lord1");
        userPojo.setEmail("lorduk1@gmail.com");
        userPojo.setGender("male");
        userPojo.setStatus("active");

        Response response = given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer 65cbc4c43040ae97eb012d87fb6bb928809feb842bfeba5ea49b2969ea92ede6")
                .body(userPojo)
                .when()
                .post();
        response.then();
        response.prettyPrint();
        id = response.body().path("id");
        System.out.println(id);
    }

    @Test // patch
    public void test003 (){
        UserPojo userPojo = new UserPojo();
        userPojo.setName("Lord Patch");

        Response response = given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer 65cbc4c43040ae97eb012d87fb6bb928809feb842bfeba5ea49b2969ea92ede6")
                .pathParam("id", "4193")
                .body(userPojo)
                .when()
                .patch("/{id}");
             //   .patch(String.valueOf(id));
        response.then();
        response.prettyPrint();
        System.out.println(id);
    }

    @Test //delete
    public void test004 (){
        Response response = given()
                .pathParam("id", "4193")
                .when()
                .delete("/{id}");
        response.then();
        response.prettyPrint();
    }

    @Test // deleted id check
    public void test005 (){
        Response response = given()
                .pathParam("id", "4193")
                .when()
                .get("/{id}");
        response.then().statusCode(404);
        response.prettyPrint();
    }

}
