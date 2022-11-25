package com.endava.grocy.entity.quantityUnit;

import com.endava.grocy.TestBaseClass;
import com.endava.grocy.model.EntityType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

public class GetQuantityUnitsTest extends TestBaseClass {

    @Test
    public void shouldGetQuantityUnitsTest() {

        //when
        Response response = entityClient.getEntity(EntityType.QUANTITY_UNIT);

        //then
        response.then().statusCode(HttpStatus.SC_OK);
    }
    @Test
    public void shouldGetQuantityUnitById(){
        //given
        grocyFixture.createEntity(EntityType.QUANTITY_UNIT);
        Integer quantityUnitId = grocyFixture.getQuantityUnit().getId();

        //when
        Response response = entityClient.getEntityById(EntityType.QUANTITY_UNIT, quantityUnitId);

        //then
        response.then().statusCode(HttpStatus.SC_OK);

    }

}
