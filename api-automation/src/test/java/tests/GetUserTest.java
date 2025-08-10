package tests;

import base.BaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetUserTest extends BaseTest {
    @Test
    public void testGetUser() {
        Response response = RestAssured
                .given()
                .when()
                .get("/users/2")
                .then()
                .extract().response();

        Assert.assertEquals(response.statusCode(), 200);
        System.out.println("User Data: " + response.asString());
    }
}
