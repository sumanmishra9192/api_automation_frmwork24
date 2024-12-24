package config;



import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static utils.PropOperations.getEnvData;

public class RequestSpec {

   private static final String EMPLOYEE_BASE_URI = getEnvData("employeebaseurl");
   private static final String REQ_RES_BASE_URI = getEnvData("employeeServiceUrl");
   private static final String PET_BASE_URI = getEnvData("petServiceUrl");
   private static final String GO_REST_BASE_URI = getEnvData("goRestServiceUrl");
   private static final String GO_REST_AUTH_TOKEN = getEnvData("goRestBearerToken");

    public static RequestSpecification employeeRequestSpec(){
        return new RequestSpecBuilder()
                .setBaseUri(EMPLOYEE_BASE_URI)
                .setContentType(ContentType.JSON)
                .build();
    }

    public static RequestSpecification petRequestSpec(){
        return new RequestSpecBuilder()
                .setBaseUri(PET_BASE_URI)
                .setContentType(ContentType.JSON)
                .build();
    }

    public static RequestSpecification reqresRequestSpec(){
        return new RequestSpecBuilder()
                .setBaseUri(REQ_RES_BASE_URI)
                .setContentType(ContentType.JSON)
                .build();
    }

    public static RequestSpecification gpRestRequestSpec(){
        return new RequestSpecBuilder()
                .setBaseUri(GO_REST_BASE_URI)
                .setContentType(ContentType.JSON)
                .addHeader("Authorization" , GO_REST_AUTH_TOKEN)
                .build();
    }

}
