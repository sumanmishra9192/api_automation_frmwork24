package User;

import base.BaseRequest;
import config.RequestSpec;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojo.models.User;
import utils.RandomDataGenerator;

import static config.RequestPath.USERS;
import static utils.RandomDataGenerator.getRandomStringValue;

public class PostUserTest extends BaseRequest {


    @Test
    public void testPostRequestUser() {

        RequestSpecification requestSpecification = RequestSpec.employeeRequestSpec().basePath(USERS);
        User user = User.builder().name(getRandomStringValue(5)).
                        job(getRandomStringValue(6)).build();

        Response response =  sendPostRequest(requestSpecification, user);

        Assert.assertEquals(response.statusCode(), HttpStatus.SC_CREATED,"Status code not matched");

        User userResponse = response.as(User.class);

        Assert.assertEquals(userResponse.getName(),user.getName());
        Assert.assertEquals(userResponse.getJob(),user.getJob());
    }
}
