package com.microservices.inventoryservice.service;

import com.microservices.inventoryservice.domain.representation.InventoryRepresentation;
import com.microservices.inventoryservice.repository.InventoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class InventoryService {
    private final InventoryRepository inventoryRepository;

    public List<InventoryRepresentation> isInStock(List<String> skuCode){
         return inventoryRepository.findBySkuCodeIn(skuCode).stream()
                 .map((inventory)->InventoryRepresentation.builder()
                         .skuCode(inventory.getSkuCode())
                         .isInStock(inventory.getQuantity()>0)
                         .build()
                 ).toList();
    }

}
