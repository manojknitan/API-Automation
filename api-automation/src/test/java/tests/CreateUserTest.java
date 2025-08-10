package tests;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class CreateUserTest {

    @Test
    public void createUser() {
        RestAssured.useRelaxedHTTPSValidation();
        given()
                .contentType("application/json")
                .body("{\"name\": \"morpheus\", \"job\": \"leader\"}")
                .when()
                .post("https://reqres.in/api/users")
                .then()
                .statusCode(401)
                .body("name", equalTo("morpheus"))
                .body("job", equalTo("leader"));
    }
}
