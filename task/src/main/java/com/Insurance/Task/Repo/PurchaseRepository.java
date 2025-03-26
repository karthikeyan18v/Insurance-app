package com.Insurance.Task.Repo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.Insurance.Task.Model.Purchase;

@Repository
public class PurchaseRepository {
    private final List<Purchase> purchases = new ArrayList<>();
    private Long currentId = 1L;
    
    public Purchase save(Purchase purchase) {
        purchase.setId(currentId++);
        purchases.add(purchase);
        return purchase;
    }
    
    public Optional<Purchase> findById(Long id) {
        return purchases.stream()
            .filter(p -> p.getId().equals(id))
            .findFirst();
    }
}