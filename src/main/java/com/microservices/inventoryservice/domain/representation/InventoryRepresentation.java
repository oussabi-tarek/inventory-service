package com.microservices.inventoryservice.domain.representation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class InventoryRepresentation {
    private String skuCode;
    private boolean isInStock;
}
