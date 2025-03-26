package com.Insurance.Task.Model;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Purchase {
    private Long id;
    private Long userId;
    private Long insuranceId;
    private LocalDate purchaseDate;
    private String policyDocumentPath;
    
    
    // Constructors, getters, setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getInsuranceId() {
		return insuranceId;
	}
	public void setInsuranceId(Long insuranceId) {
		this.insuranceId = insuranceId;
	}
	public LocalDate getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(LocalDate purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public String getPolicyDocumentPath() {
		return policyDocumentPath;
	}
	public void setPolicyDocumentPath(String policyDocumentPath) {
		this.policyDocumentPath = policyDocumentPath;
	}
   
    
}
