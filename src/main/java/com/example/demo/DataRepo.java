package com.example.demo;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.entity.StudentEntity;

public interface DataRepo extends CrudRepository<StudentEntity, Serializable> {

	List<StudentEntity> findByName(String searchvalue);

	List<StudentEntity> findByBranch(String searchvalue);

	List<StudentEntity> findByCollege(String searchvalue);

	List<StudentEntity> findByCity(String deleteBy);

}
