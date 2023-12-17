package com.microservices.inventoryservice.api;

import com.microservices.inventoryservice.domain.command.InventoryCommand;
import com.microservices.inventoryservice.domain.representation.InventoryRepresentation;
import com.microservices.inventoryservice.service.InventoryService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
@AllArgsConstructor
@Slf4j
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping
    public ResponseEntity<List<InventoryRepresentation>> isInStock(@RequestParam List<String> skuCode){
        log.info("InventoryController is called {}", skuCode);
        return ResponseEntity.ok(inventoryService.isInStock(skuCode));
    }
    @PostMapping
    public ResponseEntity<String> addInventory(@RequestBody InventoryCommand inventoryCommand){
        log.info("InventoryController is called {}", inventoryCommand);
        return ResponseEntity.ok(inventoryService.addInventory(inventoryCommand));
    }

}
