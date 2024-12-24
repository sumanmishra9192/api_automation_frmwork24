package base;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public abstract class BaseRequest {

    public Response sendGetRequest (RequestSpecification requestSpecification){
        return given().spec(requestSpecification).when().get().then().extract().response();
    }

    public Response sendPostRequest (RequestSpecification requestSpecification, Object body){
        return given().spec(requestSpecification).body(body).when().post().then().extract().response();
    }

    public Response sendDeleteRequest (RequestSpecification requestSpecification){
        return given().spec(requestSpecification).when().delete().then().extract().response();
    }

    public Response sendPatchRequest (RequestSpecification requestSpecification, Object body){
        return given().spec(requestSpecification).body(body).when().patch().then().extract().response();
    }

    public Response sendPutRequest (RequestSpecification requestSpecification, Object body){
        return given().spec(requestSpecification).body(body).when().put().then().extract().response();
    }
}
