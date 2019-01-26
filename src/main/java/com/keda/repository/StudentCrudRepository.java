package com.keda.repository;

import com.keda.entity.Student;
import org.springframework.data.repository.CrudRepository;

/**
 * @author songsm
 * @data 2019/1/22 下午6:44
 * @desc 用一句话描述此类的作用
 */
public interface StudentCrudRepository extends CrudRepository<Student,Integer> {


}
