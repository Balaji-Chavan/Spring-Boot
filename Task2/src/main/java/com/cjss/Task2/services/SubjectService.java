package com.cjss.Task2.services;

import com.cjss.Task2.model.Marks;
import com.cjss.Task2.model.Subjects;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubjectService {
    List<Subjects> subjectModel1 =List.of(new Subjects("s1", "Subject1", 2, "a1"),
                                         new Subjects("s2", "Subject2", 3, "a3"),
                                         new Subjects("s3", "Subject3", 2, "a2"),
                                         new Subjects("s4", "Subject3", 2, "a1"),
                                         new Subjects("s5", "Subject4", 1, "a4"),
                                         new Subjects("s6", "Subject5", 2, "a1"),
                                         new Subjects("s7", "Subject6", 3, "a1"),
                                         new Subjects("s8", "Subject7", 1, "a1"),
                                         new Subjects("s9", "Subject8", 4, "a1"),
                                         new Subjects("s10", "Subject9", 3,"a1"),
                                         new Subjects("s11","Subject10",3,"a4"),
                                         new Subjects("s12","Subject11",2,"a1"),
                                         new Subjects("s13", "Subject1", 2, "a2"),
                                         new Subjects("s14", "Subject1", 2, "a3") );


       List<Subjects> subjectModel = new ArrayList<>(subjectModel1);

    public List<Subjects> addSubjects(Subjects s){
        subjectModel.add(s);
        return subjectModel;
    }

    public List<Subjects> getSubjectsById(String id){
        return subjectModel
                .stream()
                .filter(branch -> branch.getSubId().equals(id))
                .collect(Collectors.toList());
    }

    public List<Subjects> getAllSubjects(){
        return subjectModel;
    }

    public List<Subjects> deleteById(String Id){
        List<Subjects> listOfSubjects = subjectModel
                .stream()
                .filter(branch ->!( branch.getSubId().equals(Id)))
                .collect(Collectors.toList());
        subjectModel.clear();
        subjectModel.addAll(listOfSubjects);
        return subjectModel;
    }

    public List<String> subIdListYearWise(int year){
        return subjectModel
                .stream()
                .filter(sub -> sub.getYear()==year)
                .map(sub -> sub.getSubId())
                .collect(Collectors.toList());
    }
}
