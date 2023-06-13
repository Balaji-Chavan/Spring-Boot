package com.task1.EmployeeTask1.Services;

import com.task1.EmployeeTask1.Model.Benefits;
import com.task1.EmployeeTask1.Model.Location;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BenefitsService {
    List<Benefits> benefitsModel =  List.of(new Benefits("20", "Educational Loan", "education loans are designed"
                    +"specifically for higher education and offer lower interest rates, flexible repayment options, and longer repayment tenures"),

            new Benefits("21" , "Health Insurance", "Health insurance is "
                    + "a type of insurance that covers medical expenses that arise due to an illness"),

            new Benefits("22", "Retirement Plan","A retirement plan is a type of life insurance plan designed to fulfil"
                    + "the post-retirement needs of an individual"));

    public List<Benefits> addBenefits(Benefits e){
        benefitsModel.add(e);
        return benefitsModel;
    }

    public List<Benefits> getBenefitsAll(){

        return  benefitsModel;
    }

    public List<Benefits> getBenefitsById(String id){
        return    benefitsModel
                .stream()
                .filter(location-> location.getBenefitId().equals(id))
                .collect(Collectors.toList());
    }

    public List<Benefits> deleteBenefitsById(String id){
        List<Benefits> ls  =   benefitsModel
                .stream()
                .filter(benefits -> !(benefits.getBenefitId().equals(id)))
                .collect(Collectors.toList());

        benefitsModel.clear();
        benefitsModel.addAll(ls);
        return  benefitsModel;
    }

}
