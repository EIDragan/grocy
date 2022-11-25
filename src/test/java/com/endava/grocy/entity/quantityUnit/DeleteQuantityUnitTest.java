package com.endava.grocy.entity.quantityUnit;

import com.endava.grocy.TestBaseClass;
import com.endava.grocy.model.EntityType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

public class DeleteQuantityUnitTest extends TestBaseClass {

    @Test
    public void shouldDeleteQuantityUnityId() {
        //given
        grocyFixture.createEntity(EntityType.QUANTITY_UNIT);
        Integer quantityUnitId = grocyFixture.getQuantityUnit().getId();

        //when
        Response response = entityClient.deleteEntityById(EntityType.QUANTITY_UNIT, quantityUnitId);

        //then
        response.then().statusCode(HttpStatus.SC_NO_CONTENT);

    }
}
