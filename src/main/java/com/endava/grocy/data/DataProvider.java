package com.endava.grocy.data;

import com.endava.grocy.model.*;
import com.github.javafaker.Faker;

public class DataProvider {

    private Faker faker = new Faker();

    public Product getProduct(Integer locationId, Integer quantityPurchasedId, Integer quantityStockId) {
        Product product = new Product();
        product.setName(faker.commerce().productName() + faker.number().digit());
        product.setDescription(faker.chuckNorris().fact());
        product.setLocationId(locationId);
        product.setMinStockAmount(faker.number().numberBetween(0, 10));
        product.setQuantityPurchaseId(quantityPurchasedId);
        product.setQuantityStockId(quantityStockId);
        product.setQuantityFactorPurchaseToStock(faker.number().randomDouble(4, 0, 100));

        return product;
    }

    public Location getLocation() {
        Location location = new Location();
        location.setName(faker.relationships().any() + " " + faker.name().fullName());
        location.setDescription(faker.friends().quote());
        location.setIsFreezer(faker.options().option(0, 1));

        return location;
    }

    public QuantityUnit getQuantityUnit() {
        QuantityUnit quantityUnit = new QuantityUnit();
        quantityUnit.setName(faker.food().measurement() + " " + faker.number().digit());
        quantityUnit.setNamePlural(quantityUnit.getName() + "s");
        quantityUnit.setDescription(faker.backToTheFuture().quote());

        return quantityUnit;
    }

    public Stock getStock() {
        Stock stock = new Stock();
        stock.setAmount(faker.number().randomDouble(2, 0, 500));
        stock.setTransactionType(TransactionType.PURCHASE);
        stock.setPrice(faker.number().randomDouble(2, 0, 1000));
        return stock;
    }

}
