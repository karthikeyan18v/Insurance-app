package com.Insurance.Task.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Insurance.Task.Model.Insurance;
import com.Insurance.Task.Service.InsuranceService;

@RestController
@RequestMapping("/api/insurances")
public class InsuranceController {
    private final InsuranceService insuranceService;

    // Constructor injection
    public InsuranceController(InsuranceService insuranceService) {
        this.insuranceService = insuranceService;
    }

    @GetMapping
    public ResponseEntity<List<Insurance>> getAllInsurances(
            @RequestParam(required = false) Integer age,
            @RequestParam(required = false) String gender,
            @RequestParam(required = false) Double income) {
        
        if (age != null || gender != null || income != null) {
            return ResponseEntity.ok(
                insuranceService.getCuratedInsurances(age, gender, income)
            );
        }
        return ResponseEntity.ok(insuranceService.getAllInsurances());
    }
}
