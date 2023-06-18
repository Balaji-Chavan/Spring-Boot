package com.jpa.crud.JpaCrudDemo.repository;

import com.jpa.crud.JpaCrudDemo.entity.StudentEntity;
import com.jpa.crud.JpaCrudDemo.model.Response;
import com.jpa.crud.JpaCrudDemo.model.StudentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<StudentEntity, Integer> {

//@Query("FROM StudentEntity WHERE branch = ?1")
//    public List<StudentEntity> getByBranch(String branch);

//    @Query("SELECT s FROM StudentEntity s WHERE s.branch=:n")
//    public List<StudentEntity> getByBranch(@Param("n") String branch);

    @Query(value ="SELECT *  FROM student s WHERE s.branch=:n",nativeQuery = true)
    public List<StudentEntity> getByBranch(@Param("n") String branch);



@Query("SELECT new com.jpa.crud.JpaCrudDemo.model.Response(s.name,s.branch,s.mob_no) FROM StudentEntity s WHERE s.branch=:n")
    public List<Response> getParticularInfo(@Param("n") String name);



@Query(value="Select * from student s order by s.name  ASC",nativeQuery = true)
public List<StudentEntity> orderByName();



//    @Query("FROM StudentEntity order by name ASC")
//    public List<StudentEntity> orderByName();

}








