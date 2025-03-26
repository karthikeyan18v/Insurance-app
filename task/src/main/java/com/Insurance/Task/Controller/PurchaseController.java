package com.Insurance.Task.Controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Insurance.Task.Model.Purchase;
import com.Insurance.Task.Service.PurchaseService;
import com.Insurance.Task.dto.PurchaseRequest;

import jakarta.annotation.Resource;

@RestController
@RequestMapping("/api/purchases")
public class PurchaseController {
    private final PurchaseService purchaseService;

    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @PostMapping
    public ResponseEntity<Purchase> purchaseInsurance(@RequestBody PurchaseRequest request) {
        Purchase purchase = purchaseService.createPurchase(request);
        return ResponseEntity.ok(purchase);
    }

    @GetMapping("/{purchaseId}/policy")
    public ResponseEntity<org.springframework.core.io.Resource> downloadPolicy(@PathVariable Long purchaseId) {
        org.springframework.core.io.Resource policy = purchaseService.getPolicyDocument(purchaseId);
        return ResponseEntity.ok()
            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"policy.pdf\"")
            .body(policy);
    }
}