package com.Insurance.Task.Repo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.Insurance.Task.Model.Insurance;

@Repository
public class InsuranceRepository {
    private List<Insurance> insurances = new ArrayList<>();
    
    // Initialize with sample data
    public InsuranceRepository() {
        insurances.add(new Insurance(
            1L,                                   // id
            "Term Life",                          // name
            "Basic life coverage",                // description
            100000.0,                             // coverageAmount
            50.0,                                 // premium
            18,                                    // minAge
            65,                                    // maxAge
            "Any",                                 // eligibleGender
            25000.0                               // minIncome
        ));
        
        insurances.add(new Insurance(
            2L,
            "Senior Health",
            "Health insurance for seniors",
            50000.0,
            200.0,
            60,
            100,
            "Any",
            40000.0
        ));
        insurances.add(new Insurance(
                3L,
                "Health care",
                "Health insurance for family",
                60000.0,
                100.0,
                30,
                100,
                "Any",
                50000.0
            ));
    }

    public List<Insurance> findAll() {
        return insurances;
    }

    public Optional<Insurance> findById(Long id) {
        return insurances.stream().filter(i -> i.getId().equals(id)).findFirst();
    }
}
