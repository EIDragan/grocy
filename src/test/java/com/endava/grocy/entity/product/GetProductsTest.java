package com.endava.grocy.entity.product;

import com.endava.grocy.TestBaseClass;
import com.endava.grocy.model.EntityType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

public class GetProductsTest extends TestBaseClass {

    @Test
    public void shouldGetProductsList() {

        //when
        Response response = entityClient.getEntity(EntityType.PRODUCTS);

        //then
        response.then().statusCode(HttpStatus.SC_OK);

    }

    @Test
    public void shouldGetProductByIdGivenProductId() {
        //GIVEN
        grocyFixture.createEntity(EntityType.LOCATION)
                .createEntity(EntityType.QUANTITY_UNIT)
                .createEntity(EntityType.PRODUCTS);
        Integer productId = grocyFixture.getProduct().getId();

        //WHEN
        Response response = entityClient.getEntityById(EntityType.PRODUCTS, productId);

        //THEN
        response.then().statusCode(HttpStatus.SC_OK);

    }
}
