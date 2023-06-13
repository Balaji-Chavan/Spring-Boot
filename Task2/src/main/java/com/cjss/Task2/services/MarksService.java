package com.cjss.Task2.services;

import com.cjss.Task2.model.Branch;
import com.cjss.Task2.model.Marks;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class MarksService {


    List<Marks> marksModel1 = Arrays.asList(
        new Marks("st1", Map.of(1, "Pass")),
        new Marks("st2", Map.of(1, "Fail")),
        new Marks("st3", Map.of(2, "Pass")),
        new Marks("st4", Map.of(2, "Fail")),
        new Marks("st5", Map.of(3, "Fail")),
        new Marks("st6", Map.of(3, "Pass")),
        new Marks("st7", Map.of(4, "Pass")),
        new Marks("st8", Map.of(4, "Pass")),
        new Marks("st9", Map.of(1, "Pass")),
        new Marks("st10", Map.of(1, "Pass")),
        new Marks("st11", Map.of(1, "Fail")),
        new Marks("st12", Map.of(1, "Pass")),
        new Marks("st13", Map.of(1, "Pass")),
        new Marks("st14", Map.of(1, "Fail")),
        new Marks("st15", Map.of(1, "Pass"))
);

    List<Marks> marksModel = new ArrayList<>(marksModel1);

    public List<Marks> addMarks(Marks m){
        marksModel.add(m);
        return marksModel;
    }

    public List<Marks> getMarksById(String id){
        return marksModel
                .stream()
                .filter(branch -> branch.getSid().equals(id))
                .collect(Collectors.toList());
    }

    public List<Marks> getAllMarks(){
        return marksModel;
    }

    public List<Marks> deleteById(String Id){
        List<Marks> listOfMarks = marksModel
                .stream()
                .filter(branch ->!( branch.getSid().equals(Id)))
                .collect(Collectors.toList());
        marksModel.clear();
        marksModel.addAll(listOfMarks);
        return marksModel;
    }



    public List<String> listOfFailedStudentId(List<String> listOfStdIdYearWise , int year){
      return  marksModel
               .stream()
               .filter(marks -> listOfStdIdYearWise.contains(marks.getSid()))
               .filter(marks -> marks.getMarks().get(year).equals("Fail"))
               .map(marks ->marks.getSid())
               .collect(Collectors.toList());
    }
}
