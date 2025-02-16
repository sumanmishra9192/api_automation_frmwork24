package petstroretest;

import base.BaseRequest;
import config.RequestPath;
import config.RequestSpec;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojo.models.PetStore;
import utils.RandomDataGenerator;

public class PetStoreOrderTest extends BaseRequest {

    @Test
    public void petStoreOrder() {
        RequestSpecification requestSpecification = RequestSpec.petRequestSpec()
                .basePath(RequestPath.STORE_ORDER);

        PetStore petStore = PetStore.builder()
                .petId(RandomDataGenerator.getRandomIntValue(2))
                .id(RandomDataGenerator.getRandomIntValue(2))
                .quantity(1)
                .shipDate("2025-01-26T03:52:47.655+0000")
                .complete(true).build();

        Response response = sendPostRequest(requestSpecification,petStore);

        Assert.assertEquals(response.statusCode(), HttpStatus.SC_OK,"Status code not matching");

        PetStore petStoreresponse = response.as(PetStore.class);

        Assert.assertEquals(petStore.getId(),petStoreresponse.getId());
        Assert.assertEquals(petStore.getPetId(),petStoreresponse.getPetId());
        Assert.assertEquals(petStore.getQuantity(),petStoreresponse.getQuantity());
        Assert.assertEquals(petStore.getStatus(),petStoreresponse.getStatus());
        Assert.assertEquals(petStore.isComplete(),petStoreresponse.isComplete());



    }
}
