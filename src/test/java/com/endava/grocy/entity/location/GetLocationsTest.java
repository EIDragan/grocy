package com.endava.grocy.entity.location;

import com.endava.grocy.TestBaseClass;
import com.endava.grocy.model.EntityType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

public class GetLocationsTest extends TestBaseClass {

    @Test
    public void shouldGetLocations() {
        //GIVEN

        //WHEN
        Response response = entityClient.getEntity(EntityType.LOCATION);

        //THEN
        response.then().statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void shouldGetLocationGivenLocationId() {
        //GIVEN
        grocyFixture.createEntity(EntityType.LOCATION);
        Integer locationId = grocyFixture.getLocation().getId();

        //WHEN
        Response response = entityClient.getEntityById(EntityType.LOCATION, locationId);

        //THEN
        response.then().statusCode(HttpStatus.SC_OK);
    }

}
