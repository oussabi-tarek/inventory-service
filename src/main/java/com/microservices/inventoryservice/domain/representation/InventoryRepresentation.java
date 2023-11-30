package com.microservices.inventoryservice.domain.representation;

import lombok.Builder;

@Builder
public class InventoryRepresentation {
    private String skuCode;
    private boolean isInStock;
}
