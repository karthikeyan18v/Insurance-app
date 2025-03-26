package com.Insurance.Task.dto;

public class PurchaseRequest {
    private Long userId;
    private Long insuranceId;

    // Constructors
    public PurchaseRequest() {}
    
    public PurchaseRequest(Long userId, Long insuranceId) {
        this.userId = userId;
        this.insuranceId = insuranceId;
    }

    // Getters and Setters
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
    
    public Long getInsuranceId() { return insuranceId; }
    public void setInsuranceId(Long insuranceId) { this.insuranceId = insuranceId; }
}
