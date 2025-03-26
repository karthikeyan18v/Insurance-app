package com.Insurance.Task.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.Insurance.Task.Model.Insurance;
import com.Insurance.Task.Repo.InsuranceRepository;

@Service
public class InsuranceService {
    private final InsuranceRepository insuranceRepository;

    // Constructor injection
    public InsuranceService(InsuranceRepository insuranceRepository) {
        this.insuranceRepository = insuranceRepository;
    }

    // Add this new method
    public List<Insurance> getAllInsurances() {
        return insuranceRepository.findAll();
    }

    // Existing method
    public List<Insurance> getCuratedInsurances(Integer age, String gender, Double income) {
        return insuranceRepository.findAll().stream()
                .filter(insurance -> meetsEligibility(insurance, age, gender, income))
                .collect(Collectors.toList());
    }

    // Keep your existing eligibility check logic
    private boolean meetsEligibility(Insurance insurance, Integer age, String gender, Double income) {

        boolean ageValid = age >= insurance.getMinAge() && age <= insurance.getMaxAge();
        boolean genderValid = insurance.getGender().equalsIgnoreCase("Any") || 
                             insurance.getGender().equalsIgnoreCase(gender);
        boolean incomeValid = income >= insurance.getMinIncome();
        
        return ageValid && genderValid && incomeValid;
    
    }
}
