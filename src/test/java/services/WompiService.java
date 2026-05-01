package services;

import base.BaseAPI;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import utils.Constants;

public class WompiService extends BaseAPI {

    public Response createTransaction(Object body) {
        return request
                .body(body)
                .post("/transactions");
    }

    public Response createTransactionWithoutAuth(Object body) {
        return RestAssured.given()
                .baseUri(Constants.BASE_URL)
                .contentType("application/json")
                .body(body)
                .post("/transactions");
    }
}