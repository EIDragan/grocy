package com.endava.grocy.client;

import com.endava.grocy.model.Entity;
import com.endava.grocy.model.EntityType;
import com.endava.grocy.model.Product;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

public class EntityClient extends BaseClient {

        public Response createEntity(EntityType entityType, Entity entity){

        return getBasicRestConfig()
                .contentType(ContentType.JSON)
                .body(entity)
                .pathParam("entity", entityType)
                .post("objects/{entity}");

    }

    public Response deleteEntityById(EntityType entity, Integer productId){

        return getBasicRestConfig()
                .pathParam("entity", entity)
                .pathParam("objectId", productId)
                .delete("objects/{entity}/{objectId}");

    }
}