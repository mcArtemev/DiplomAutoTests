package POM.Helpers;

import POM.BaseData;
import io.restassured.response.Response;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;
import static org.awaitility.Awaitility.await;

public class APICalls extends BaseData {
    public Response createUser(UserSerializer userJsonData) {
        Response response = given()
                .baseUri(baseURI)
                .header("Content-type", "application/json")
                .and()
                .body(userJsonData)
                .when()
                .post("/api/auth/register");
        return response;
    }
    public void deleteUser(String userToken) {
        given()
                .baseUri(baseURI)
                .header("Authorization", userToken)
                .when()
                .delete("/api/auth/user")
                .then()
                .statusCode(202);
    }
    public Response loginUser(UserSerializer userJsonData) {
        Response response = given()
                .baseUri(baseURI)
                .header("Content-type", "application/json")
                .and()
                .body(userJsonData)
                .when()
                .post("/api/auth/login");
        return response;
    }

    public boolean checkCreatedUser(UserSerializer userJsonData) {
        Response response = loginUser(userJsonData);
        await().atMost(10, TimeUnit.SECONDS)
                .until(() -> {
                    response.then().assertThat().statusCode(200);
                    return response.as(UserDeserializer.class).getUser().getEmail().equals(userJsonData.getEmail());
                });
        return response.as(UserDeserializer.class).getUser().getEmail().equals(userJsonData.getEmail());
    }
}
