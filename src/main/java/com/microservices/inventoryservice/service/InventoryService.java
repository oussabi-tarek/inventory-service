package com.microservices.inventoryservice.service;

import com.microservices.inventoryservice.domain.command.InventoryCommand;
import com.microservices.inventoryservice.domain.model.Inventory;
import com.microservices.inventoryservice.domain.representation.InventoryRepresentation;
import com.microservices.inventoryservice.repository.InventoryRepository;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class InventoryService {
    private final InventoryRepository inventoryRepository;

    // the transactional annotation with readOnly=true will make sure that the transaction is read only
    // and will not write anything to the database
    @Transactional(readOnly=true)
    @SneakyThrows
    public List<InventoryRepresentation> isInStock(List<String> skuCode){
        // this is just to simulate a delay in the service call so that we can see the circuit breaker in action
//        log.info("Wait started");
//        Thread.sleep(5000);
//        log.info("Wait ended");
         return inventoryRepository.findBySkuCodeIn(skuCode).stream()
                 .map((inventory)->InventoryRepresentation.builder()
                         .skuCode(inventory.getSkuCode())
                         .isInStock(inventory.getQuantity()>0)
                         .build()
                 ).toList();
    }
    // add product to the inventory
    public String addInventory(InventoryCommand inventoryCommand){
        return inventoryRepository.save(Inventory.builder()
                .skuCode(inventoryCommand.getSkuCode())
                .quantity(inventoryCommand.getQuantity()).build()).getId().toString();
    }
}
