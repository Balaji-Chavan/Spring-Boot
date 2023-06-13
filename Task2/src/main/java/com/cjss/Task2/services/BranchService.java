package com.cjss.Task2.services;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import  com.cjss.Task2.model.Branch;
import org.springframework.stereotype.Service;

@Service
public class BranchService {
    List<Branch> branchModel1 =  Arrays.asList(new Branch("a1","CSE"),
                                              new Branch("a2","IT"),
                                              new Branch("a3","CIVIL"),
                                              new Branch("a4","MECH"),
                                              new Branch("a5","ENTC"),
                                              new Branch("a6","ELECTRICAL"));
    List<Branch> branchModel = new ArrayList<>(branchModel1);

    public List<Branch> addBranch(Branch b){
        branchModel.add(b);
        return branchModel;
    }

    public List<Branch> getBranchById(String id){
        return branchModel
                .stream()
                .filter(branch -> branch.getBranchId().equals(id))
                .collect(Collectors.toList());
    }

    public List<Branch> getAllBranch(){
        return branchModel;
    }

    public List<Branch> deleteById(String Id){
        List<Branch> listOfBranch = branchModel
                                    .stream()
                                   .filter(branch ->!( branch.getBranchId().equals(Id)))
                                  .collect(Collectors.toList());
        branchModel.clear();
        branchModel.addAll(listOfBranch);
        return branchModel;
    }
}
