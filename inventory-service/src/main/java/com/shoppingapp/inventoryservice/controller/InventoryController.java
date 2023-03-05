package com.shoppingapp.inventoryservice.controller;

import com.shoppingapp.inventoryservice.dto.InventoryResponse;
import com.shoppingapp.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/{sku-code}")
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {
    private final InventoryService inventoryService;

//    for single item
//    http://localhost:8082/api/inventory/iphone-13
//    @GetMapping
//    @ResponseStatus(HttpStatus.OK)
//    public boolean isInStock(@PathVariable("sku-code") String skuCode){
//        return inventoryService.isInStock(skuCode);
//    }

//    for multiple items in the cart
//    http://localhost:8082/api/inventory/?skuCode=iphone-13&skuCode=iphone-14
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryResponse> isInStock(@RequestParam List<String> skuCode){
        return inventoryService.isInStock(skuCode);
    }
}
