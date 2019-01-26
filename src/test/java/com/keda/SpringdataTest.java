package com.keda;

import com.keda.entity.Student;
import com.keda.repository.StudentCrudRepository;
import com.keda.repository.StudentRepository;
import com.keda.repository.StudentpagesortRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

/**
 * @author songsm
 * @data 2019/1/20 下午5:54
 * @desc 用一句话描述此类的作用
 */
public class SpringdataTest {

    private ApplicationContext applicationContext =null;


    private StudentRepository studentRepository=null;

    private StudentCrudRepository studentCrudRepository=null;

    private StudentpagesortRepository studentpagesortRepository = null;


    @Before
    public void before(){

        applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        studentRepository = applicationContext.getBean(StudentRepository.class);
        studentCrudRepository = applicationContext.getBean(StudentCrudRepository.class);
        studentpagesortRepository = applicationContext.getBean(StudentpagesortRepository.class);

        System.out.println("before");
    }
    @After
    public void after(){
        applicationContext = null;
        System.out.println("after");
    }

//    @Test
//    public void testEntityManagerFactory(){}
//    @Test
//    public void saveStudent(){
//
//        Student student = studentRepository.findById(1);
//        System.out.println(student);
//
//    }
//      @Test
//     public void TestGetStudentById(){
//
//        Student s = studentRepository.getStudentByMaxId();
//         System.out.println(s);
//     }

     @Test
    public void TestQueryParam(){

        List<Student> students = studentRepository.queryParams1("t%", 22);

        for(Student s:students){
            System.out.println(s);
        }
    }

    @Test
    public void TestQueryParam2(){

        List<Student> students = studentRepository.queryParam2("t", 22);

        for(Student s:students){
            System.out.println(s);
        }
    }

    @Test
    public void TestQueryAll(){

        List<Student> students = studentRepository.queryAll();

        for(Student s:students){
            System.out.println(s);
        }
    }

    @Test
    public void Testupdate(){

        studentRepository.updateStudent(1,30);


    }

    @Test
    public void TestSaveStudent(){

        Student s ;
        List<Student> lists = new ArrayList<>();


        for(int i = 0;i<100;i++){
            s =new Student();
            s.setName("apple"+i);
            s.setAge(i);
            lists.add(s);

        }

        studentCrudRepository.save(lists);


    }

    @Test
    public void findStudent(){

//        Pageable pageable = new PageRequest(1,10);
//        Page<Student> all = studentpagesortRepository.findAll(pageable);
//        System.out.println(all.getContent().size());
//        System.out.println(all.getTotalPages());
        Sort.Order order = new Sort.Order(Sort.Direction.DESC, "id");
        Sort sort = new Sort(order);
        Pageable pageable = new PageRequest(1,10,sort);
        Page<Student> all = studentpagesortRepository.findAll(pageable);


    }
}
