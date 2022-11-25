package com.endava.grocy.stock;

import com.endava.grocy.TestBaseClass;
import com.endava.grocy.model.EntityType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.is;

public class GetProductByIdTest extends TestBaseClass {

    @Test
    public void shouldGetProductById() {
        //GIVEN
        grocyFixture.createEntity(EntityType.LOCATION)
                .createEntity(EntityType.QUANTITY_UNIT)
                .createEntity(EntityType.PRODUCTS);
        Integer productId = grocyFixture.getProduct().getId();

        //WHEN
        Response response = stockClient.getProduct(productId);

        //THEN
        response.then().statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void shouldFailGivenInvalidId() {
        //GIVEN
        grocyFixture.createEntity(EntityType.LOCATION)
                .createEntity(EntityType.QUANTITY_UNIT)
                .createEntity(EntityType.PRODUCTS);
        Integer productId = grocyFixture.getProduct().getId();
        productId = 0;

        //WHEN
        Response response = stockClient.getProduct(productId);

        //THEN
        response.then().statusCode(HttpStatus.SC_BAD_REQUEST)
                .body("error_message", is("Product does not exist or is inactive"));

    }

}
