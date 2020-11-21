package com.example.mikael.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * course
 * @author
 */
@Data
public class Course implements Serializable {
    /**
     * id
     */
    private Integer id;

    /**
     * 学号
     */
    private Integer studentid;

    /**
     * 课程id
     */
    private Integer courseid;

    /**
     * 分数
     */
    private String grade;

    /**
     * 发布时间
     */
    private Date time;

    private static final long serialVersionUID = 1L;

    public Course(Integer id, Integer studentid, Integer courseid, String grade, Date time) {
        this.id = id;
        this.studentid = studentid;
        this.courseid = courseid;
        this.grade = grade;
        this.time = time;
    }
}