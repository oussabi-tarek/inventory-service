package com.microservices.inventoryservice.domain.command;

import lombok.Getter;

@Getter
public class InventoryCommand {
  private String skuCode;
  private Integer quantity;
}
