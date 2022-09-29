package in.co.gorest.asstraction;

import in.co.gorest.testbase.TestBase;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class Assertion extends TestBase {

    static ValidatableResponse response;
    @BeforeClass
    public static void inIt(){
        RestAssured.baseURI="https://gorest.co.in";
        RestAssured.basePath="/public/v2/users";
        response = given()
                .when()
                .get("")
                .then().statusCode(200);
    }


    //Vetify the following data from response
    //1.Total records are 20
    @Test
            public void test001(){
    List<Integer> records = response.extract().path("x");
    int noOfRecords = records.size();
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The no of service where store name is Rochester : " + noOfRecords);
        System.out.println("------------------End of Test---------------------------");

    }
    //2.id 2492 has name = "Fr. Gatik Ahluwalia"
    @Test
    public void test002 (){
    response.body("x[].name", equalTo("Aalok Kocchar"));
    response.body("name", equalTo(""));
        //       String name= response.extract().path("data.finaALl{it.x[0]id==2266}.name");
//        System.out.println("------------------StartingTest---------------------------");
//        System.out.println("The no of service where store name is Rochester : " + name);
//        System.out.println("------------------End of Test---------------------------");
    }
    //3.id 2483 has email = "birjesh_acharya@brown.net"
    @Test
    public void test003 (){response.body("x[1].email", equalTo("chattopadhyay_birjesh_dr@crona.name"));    }
    //4.All ID has status = "active"
    @Test
    public void test004 (){ response.body("status", equalTo("active"));}
    //5.id 2472 has gender = "female"
    @Test
    public void test005 (){response.body("x[2].gender", equalTo("female"));}
    //6.id 2471 has gender = "male"
    @Test
    public void test006 (){
        response.body("x[0].gender", equalTo("male"));    }

}
