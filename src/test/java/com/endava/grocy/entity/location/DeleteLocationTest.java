package com.endava.grocy.entity.location;

import com.endava.grocy.TestBaseClass;
import com.endava.grocy.model.EntityType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

public class DeleteLocationTest extends TestBaseClass {

    @Test
    public void shouldDeleteLocationById() {
        //given
        grocyFixture.createEntity(EntityType.LOCATION);
        Integer locationId = grocyFixture.getLocation().getId();

        //when
        Response response = entityClient.deleteEntityById(EntityType.LOCATION, locationId);

        //then
        response.then().statusCode(HttpStatus.SC_NO_CONTENT);

    }

}
