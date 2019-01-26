package com.keda.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author songsm
 * @data 2019/1/20 下午5:51
 * @desc 用一句话描述此类的作用
 */
@Entity
@Data
@Table(name = "test_student")
public class Student {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(length = 20)
    private String name;

    private Integer age;
}
