package POM.Helpers;

import POM.BaseData;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

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
        response.then().assertThat().statusCode(200);
        if(response.as(UserDeserializer.class).getUser().getEmail().equals(userJsonData.getEmail())) {
            return true;
        } else {
            return false;
        }
    }
}
