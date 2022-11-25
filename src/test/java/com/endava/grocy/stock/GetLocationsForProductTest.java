package com.endava.grocy.stock;

import com.endava.grocy.TestBaseClass;
import com.endava.grocy.model.EntityType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

public class GetLocationsForProductTest extends TestBaseClass {

    @Test
    public void shouldGetLocationsForProducts() {
        //GIVEN
        grocyFixture.createEntity(EntityType.LOCATION)
                .createEntity(EntityType.QUANTITY_UNIT)
                .createEntity(EntityType.PRODUCTS);
        Integer productId = grocyFixture.getProduct().getId();

        //WHEN
        Response response = stockClient.getLocationsForProductWithId(productId);

        //THEN
        response.then().statusCode(HttpStatus.SC_OK);

    }

}
