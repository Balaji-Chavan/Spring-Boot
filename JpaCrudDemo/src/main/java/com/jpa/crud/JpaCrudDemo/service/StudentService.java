package com.jpa.crud.JpaCrudDemo.service;

import com.jpa.crud.JpaCrudDemo.entity.StudentEntity;
import com.jpa.crud.JpaCrudDemo.model.Response;
import com.jpa.crud.JpaCrudDemo.model.StudentModel;
import com.jpa.crud.JpaCrudDemo.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService {
    @Autowired
    StudentRepo studentRepo;

    public void addStudent(StudentModel studentModel) {
        StudentEntity studentEntity = new StudentEntity(studentModel.getId(),
                studentModel.getName(),
                studentModel.getEmail(),
                studentModel.getBranch(),
                studentModel.getMob_no());

        studentRepo.save(studentEntity);
    }

    public List<StudentModel> getAllStudent() {

        List<StudentEntity> listOfStudentEntity = studentRepo.findAll();

        if (listOfStudentEntity.size() > 0) {
            return listOfStudentEntity
                    .stream()
                    .map(student -> {
                        StudentModel sm = new StudentModel(student.getId(),
                                student.getName(),
                                student.getEmail(),
                                student.getBranch(),
                                student.getMob_no());
                        return sm;
                    }).collect(Collectors.toList());
          /*
           List<StudentModel> listOfStudentModel = new ArrayList<>();
           listOfStudentEntity
           .forEach(student -> {
               StudentModel sm = new StudentModel(student.getId(),
                                                  student.getName(),
                                                   student.getEmail(),
                                                   student.getBranch(),
                                                   student.getMob_no());
           listOfStudentModel.add(sm);
            });
            return  listOfStudentModel;    */
        }
        return null;
    }


    public ResponseEntity<StudentModel> getStudentById(int id) {
        Optional<StudentEntity> optionalStudentEntity = studentRepo.findById(id);
        if (optionalStudentEntity.isPresent()) {
            StudentEntity studentEntity = optionalStudentEntity.get();
            StudentModel sm = new StudentModel(studentEntity.getId(),
                    studentEntity.getName(),
                    studentEntity.getEmail(),
                    studentEntity.getBranch(),
                    studentEntity.getMob_no());
            return ResponseEntity.of(Optional.of(sm));

        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


    public ResponseEntity<Optional<Void>> deleteStudentById(int id) {
        Optional<StudentEntity> optionalStudentEntity = studentRepo.findById(id);
        if (optionalStudentEntity.isPresent()) {
            studentRepo.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    public void updateStudent(StudentModel studentModel, int id) {
        Optional<StudentEntity> optionalStudentEntity = studentRepo.findById(id);
        if (optionalStudentEntity.isPresent()) {
            StudentEntity studentEntity = optionalStudentEntity.get();

            studentEntity.setBranch(studentModel.getBranch());
            studentEntity.setEmail(studentModel.getEmail());
            studentEntity.setMob_no(studentModel.getMob_no());
            studentRepo.save(studentEntity);
        }
    }

    public List<StudentModel> getinfoBranchWise(@PathVariable String branch) {
        List<StudentEntity> listOfStudentEntity = studentRepo.getByBranch(branch);
        if (listOfStudentEntity.size() > 0) {
            return listOfStudentEntity
                    .stream()
                    .map(student -> {
                        StudentModel sm = new StudentModel(student.getId(),
                                student.getName(),
                                student.getEmail(),
                                student.getBranch(),
                                student.getMob_no());
                        return sm;
                    }).collect(Collectors.toList());
        }
        return null;
    }

    public List<StudentModel> orderByName() {
        List<StudentEntity> listOfStudentEntity = studentRepo.orderByName();
        if (listOfStudentEntity.size() > 0) {
            return listOfStudentEntity
                    .stream()
                    .map(student -> {
                        StudentModel sm = new StudentModel(student.getId(),
                                student.getName(),
                                student.getEmail(),
                                student.getBranch(),
                                student.getMob_no());
                        return sm;
                    }).collect(Collectors.toList());
        }
        return null;
    }

    public List<Response> getResponse(String name){
       return studentRepo.getParticularInfo(name);
    }

}