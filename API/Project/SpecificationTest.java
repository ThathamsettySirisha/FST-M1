package examples;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.matcher.DetailedCookieMatcher;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import io.restassured.specification.*;
import org.hamcrest.Matcher;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

public class SpecificationTest {
    // Specification usability cases
    RequestSpecification requestSpec;
    ResponseSpecification responseSpec;

    int petId;

    @BeforeClass
    public void setup() {
        // request specification

        requestSpec = new RequestSpecBuilder()
                .setBaseUri("https://petstore.swagger.io/v2/pet")
                .addHeader("Content-Type", "application/json")
                .build();

        //response specification header ,body , status ,time
        responseSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectBody("status", equalTo("alive"))
                .expectResponseTime(lessThanOrEqualTo(3000L))
                .build();

    }

    @Test
    public void postRequestTest() {

        Map<String, Object> reqBody = new HashMap<>();
        reqBody.put("id", 77232);
        reqBody.put("name", "Riley");
        reqBody.put("status", "alive");

        //Send post request
        Response response = given().spec(requestSpec).body(reqBody).when().post();
        System.out.println(response.getBody().asString());

        petId = response.then().extract().path("id");
        System.out.println(petId);

        //Assertion
        response.then().spec(responseSpec).body("name", equalTo("Riley"));

    }

    @Test
    public void getRequestTest() {
      // Send Get Request
        given().spec(requestSpec).pathParams("petID", petId).
        when().get("/{petID}")
      .then().spec(responseSpec).body("name", equalTo("Riley"));
    }

//    @Test
//    public void DeleteRequestTest() {
//         given().spec(requestSpec).pathParam("petID",petId)
//         .when().delete("/{petID}")
//         .then().statusCode(200)
//         .body("message", equalTo("" + petId));


//    }

}