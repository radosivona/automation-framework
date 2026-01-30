package tests;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class UserApiTests {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://httpbin.org";
    }

    @Test
    public void TC04_get_shouldReturn200_andContainUrl() {
        given()
                .when()
                .get("/get")
                .then()
                .statusCode(200)
                .body("url", containsString("https://httpbin.org/get"));
    }

    @Test
    public void TC05_post_shouldReturn200_andEchoJson() {
        String body = """
                {
                  "name": "Ivan",
                  "job": "QA"
                }
                """;

        given()
                .contentType("application/json")
                .body(body)
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("json.name", equalTo("Ivan"))
                .body("json.job", equalTo("QA"));
    }
}
