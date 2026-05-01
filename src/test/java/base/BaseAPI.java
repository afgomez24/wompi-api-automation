package base;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import utils.Constants;

public class BaseAPI {

    protected RequestSpecification request;

    public BaseAPI() {
        request = RestAssured.given()
                .baseUri(Constants.BASE_URL)
                .header("Authorization", "Bearer " + Constants.PRIVATE_KEY)
                .contentType("application/json")
                .log().all();
    }
}