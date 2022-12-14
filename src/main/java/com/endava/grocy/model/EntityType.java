package com.endava.grocy.model;

public enum EntityType {

    PRODUCTS("products"),
    CHORES("chores"),
    PRODUCT_BARCODES("product_barcodes"),
    BATTERIES("batteries"),
    LOCATION("locations"),
    QUANTITY_UNIT("quantity_units");

    private String name;

    private EntityType(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
