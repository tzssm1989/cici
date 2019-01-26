package com.keda.repository;

import com.keda.entity.Student;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author songsm
 * @data 2019/1/22 下午7:02
 * @desc 用一句话描述此类的作用
 */
public interface StudentpagesortRepository extends PagingAndSortingRepository<Student,Integer> {
}
