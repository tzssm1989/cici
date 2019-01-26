package com.keda.repository;

import com.keda.entity.Student;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

/**
 * @author songsm
 * @data 2019/1/20 下午6:12
 * @desc 用一句话描述此类的作用
 */


public interface StudentRepository extends Repository<Student,Integer>,CrudRepository<Student,Integer> {

    Student findById(Integer id);

    // where name like ?% and age <?
    List<Student> findByNameStartingWithAndAgeLessThan(String name,Integer age);

    // where name like %? and age <?
    List<Student> findByNameEndingWithAndAgeLessThan(String name,Integer age);


    // where name in (?,?....) or age <?
    List<Student> findByNameInOrAgeLessThan(List<String> names,Integer age);

    // where name in (?,?....) and age <?
    List<Student> findByNameInAndAgeLessThan(List<String> names,Integer age);

     @Query("select o from Student o where o.id=(select MAX(id) from Student )")
     Student getStudentByMaxId();

     @Query("select o from Student o where o.name like ?1 and o.age < ?2")
     List<Student> queryParams1(String name,Integer age);

    @Query("select o from Student o where o.name like %:name% and o.age < :age")
     List<Student> queryParam2(@Param("name") String name,@Param("age") Integer age);

    @Query(nativeQuery = true,value = "select * from student")
    List<Student>  queryAll();

    @Transactional
    @Modifying
    @Query("update Student o set o.age=?2 where o.id=?1")
    void updateStudent(Integer id, Integer age);



//
//    public Employee getEmployeeByMaxId();
//
//
//    public List<Employee> queryParams1(String name, Integer age);
//
//
//    public List<Employee> queryParams2(@Param("name")String name, @Param("age")Integer age);
//
//
//    public List<Employee> queryLike1(String name);
//
//
//    public List<Employee> queryLike2(@Param("name")String name);
//
//
//    public long getCount();





}
