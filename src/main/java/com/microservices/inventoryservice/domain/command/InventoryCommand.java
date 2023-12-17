package com.microservices.inventoryservice.domain.command;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class InventoryCommand {
  private String skuCode;
  private Integer quantity;
}
