package com.Insurance.Task.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Insurance {
    private Long id;
    private String name;
    private String description;
    private double coverage;
    private double premium;
    
    // Eligibility criteria
    private int minAge;
    private int maxAge;
    private String gender;
    private double minIncome;
    
    

  public Insurance(Long id, String name, String description, 
            double coverage, double premium, 
            int minAge, int maxAge, 
            String gender, double minIncome) {
this.id = id;
this.name = name;
this.description = description;
this.coverage = coverage;
this.premium = premium;
this.minAge = minAge;
this.maxAge = maxAge;
this.gender = gender;
this.minIncome = minIncome;
}
// 
//
//	public Insurance(long id2, String name2, String description2, double coverage2, double premium2, int minAge2,
//			int maxAge2, String gender2, double minIncome2) {
//		// TODO Auto-generated constructor stub
//		this.id = id;
//		this.name = name2;
//		this.description = description2;
//		this.coverage = coverage2;
//		this.premium = premium2;
//		this.minAge = minAge2;
//		this.maxAge = maxAge2;
//		this.gender = gender2;
//		this.minIncome = minIncome2;
//	}
	
	//getter setter
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getCoverage() {
		return coverage;
	}
	public void setCoverage(double coverage) {
		this.coverage = coverage;
	}
	public double getPremium() {
		return premium;
	}
	public void setPremium(double premium) {
		this.premium = premium;
	}
	public int getMinAge() {
		return minAge;
	}
	public void setMinAge(int minAge) {
		this.minAge = minAge;
	}
	public int getMaxAge() {
		return maxAge;
	}
	public void setMaxAge(int maxAge) {
		this.maxAge = maxAge;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public double getMinIncome() {
		return minIncome;
	}
	public void setMinIncome(double minIncome) {
		this.minIncome = minIncome;
	}
    
    
}