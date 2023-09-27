package activities;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

public class FirstTest {
    //Base URI

    String baseURI = "https://petstore.swagger.io/v2/pet";

    @Test
    public void getRequestWithQueryparam() {
        // Send Get request
        Response response = given()
                .header("Content-Type", "application/json")
                .queryParam("status", "alive").
                when().get(baseURI +  "/findByStatus");
        //response body

        System.out.println(response.getBody().asString());
        System.out.println(response.getBody().asPrettyString());

        //response headers

        System.out.println(response.getHeaders().asList());
        System.out.println(response.getHeader("Server"));

        //get individual objects in json extract theJson properties
        String petStatus = response.then().extract().path("[0].status");
        System.out.println("status of pet 1 is " + petStatus);

        //rest assured assertions

        response.then().statusCode(200);
        response.then().body("[0].status", equalTo("alive"));
        response.then().body("[0].name", equalTo("Riley"));
        response.then().time(lessThanOrEqualTo(3000L));

    }

    @Test
    public void getRequestWithPathparam() {

        //Send Get request
       given()
                .header("Content-Type", "application/json")
                .pathParam("petID", "77232").
                 when().get(baseURI + "/{petID}").
                then().statusCode(200)
                .body("status", equalTo("alive"))
                .body("name", equalTo("Riley"))
                .time(lessThanOrEqualTo(2000L));


    }

}